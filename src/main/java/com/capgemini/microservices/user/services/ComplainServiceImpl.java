package com.capgemini.microservices.user.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.microservices.user.exception.NullValueException;
import com.capgemini.microservices.user.exception.RegistrationException;
import com.capgemini.microservices.user.exception.UnAuthorizedException;
import com.capgemini.microservices.user.exception.UserNotFoundException;
import com.capgemini.microservices.user.mail.MailService;
import com.capgemini.microservices.user.model.Complain;
import com.capgemini.microservices.user.model.ComplainDTO;
import com.capgemini.microservices.user.model.MailDTO;
import com.capgemini.microservices.user.model.User;
import com.capgemini.microservices.user.repository.UserComplainRepository;
import com.capgemini.microservices.user.repository.UserRepository;
import com.capgemini.microservices.user.utility.UserUtility;

@Service
public class ComplainServiceImpl implements ComplainService {

	@Autowired
	private UserRepository userRepository; // extends mongoRepository
	
	@Autowired
	private UserComplainRepository userComplainRepository;

	/*@Autowired
	private ProducerService producer;
	*/
	/*@Autowired
	private ElasticRepositoryForUser userElasticRepository;*/
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private JwtToken jwtToken;
	
	@Autowired
	private PasswordEncoder passwordEncoder;


	@Override
	public String registerComplain(ComplainDTO dto,String password) throws UserNotFoundException, RegistrationException, UnAuthorizedException{

		UserUtility.validateUser(dto);
		Optional<User> checkUser = userRepository.findByEmail(dto.getEmail());

		if (!checkUser.isPresent()) {
			throw new UserNotFoundException("User email doesn't exists,unable to register complain,sign up first");

		}
				
		if(!passwordEncoder.matches(password,checkUser.get().getPassword())) {
			throw new UnAuthorizedException(environment.getProperty("UnAuthorizedException"));
		}
		Complain complain = new Complain();
	    complain.setComplain(dto.getComplain());
	    complain.setEmail(dto.getEmail());
	    complain.setProductName(dto.getProductName());

		userComplainRepository.insert(complain);
		//userElasticRepository.save(user);

		String jwt = jwtToken.tokenGenerator(complain.getComplainId());

		jwtToken.parseJwtToken(jwt);

		MailDTO mail = new MailDTO();
		mail.setTo(dto.getEmail());
		mail.setSubject("Account activation mail");
		mail.setText(environment.getProperty("accountActivationLink") + jwt);
		//producer.sender(mail);
		mailService.sendMail(mail);
		return jwt;
	}

	@Override
	public void deleteComplain(String productName,String userEmail,String password) throws UserNotFoundException, UnAuthorizedException, NullValueException {
		Optional<Complain> checkComplain = userComplainRepository.findByEmail(userEmail);

		if (!checkComplain.isPresent()) {
			throw new UserNotFoundException("No any complain from user with given email");

		}
		
		if(!checkComplain.get().getProductName().equals(productName)) {
			throw new NullValueException("No such product complain present");
		}
				
		Optional<User> checkUser=userRepository.findByEmail(userEmail);
		if(!passwordEncoder.matches(password,checkUser.get().getPassword())) {
			throw new UnAuthorizedException(environment.getProperty("UnAuthorizedException"));
		}

		//userComplainRepository.deleteByProductNameAndEmail(productName,userEmail);
		userComplainRepository.deleteByProductName(productName);


		MailDTO mail = new MailDTO();
		mail.setTo(userEmail);
		mail.setSubject("complain deletion");
		mail.setText("complain with id "+productName+"deleted successfully");
		//producer.sender(mail);
		mailService.sendMail(mail);
	}

	@Override
	public List<Complain> getAllComplaints() {
			List<Complain> complainList = userComplainRepository.findAll();
			return complainList;
		}

	}
