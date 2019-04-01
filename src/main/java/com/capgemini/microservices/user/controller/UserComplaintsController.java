package com.capgemini.microservices.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.microservices.user.exception.NullValueException;
import com.capgemini.microservices.user.exception.RegistrationException;
import com.capgemini.microservices.user.exception.UnAuthorizedException;
import com.capgemini.microservices.user.exception.UserNotFoundException;
import com.capgemini.microservices.user.model.Complain;
import com.capgemini.microservices.user.model.ComplainDTO;
import com.capgemini.microservices.user.model.ResponseDTO;
import com.capgemini.microservices.user.services.ComplainService;

@RestController
@RequestMapping("/complaints")
public class UserComplaintsController {

	@Autowired
	private ComplainService complainService;
	
	public static final Logger logger = LoggerFactory.getLogger(UserComplaintsController.class);
	
	//-------------Get All Complaints--------------------------
	
		@RequestMapping(value = "/complaints", method = RequestMethod.GET)
		public List<Complain> getAllUsers() {
			return complainService.getAllComplaints();
		}

	//-----------------------Register-complaints------------------------
	
	@RequestMapping(value = "/register-complaints", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> registerUserComplaints(@RequestBody ComplainDTO complain,@RequestParam(value="rootAccountPassword") String password) throws UserNotFoundException, RegistrationException, UnAuthorizedException {

		complainService.registerComplain(complain,password);
		
		ResponseDTO response = new ResponseDTO();
		response.setMessage("Your complain registered successfully");
		response.setStatus(1);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/delete-complaints", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> deleteUserComplaints(@RequestParam(value="productName") String productName,@RequestParam(value="userEmail")String email,@RequestParam(value="rootAccountPassword") String password) throws UserNotFoundException, RegistrationException, UnAuthorizedException, NullValueException {

		complainService.deleteComplain(productName,email,password);
		
		ResponseDTO response = new ResponseDTO();
		response.setMessage("complain with id "+productName+"deleted successfully");
		response.setStatus(2);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
