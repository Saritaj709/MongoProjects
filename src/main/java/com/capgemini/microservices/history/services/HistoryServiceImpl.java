package com.capgemini.microservices.history.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.microservices.history.exception.NullValueException;
import com.capgemini.microservices.history.model.PaymentHistory;
import com.capgemini.microservices.history.repository.HistoryRepository;

@Service
public class HistoryServiceImpl implements HistoryService {

	/*@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private MailService mailService;

	@Autowired
	private Environment environment;

	@Autowired
	private JwtToken jwtToken;
*/
	@Autowired
	private HistoryRepository historyRepository;

	@Override
	public List<PaymentHistory> getAllUsers() {

		List<PaymentHistory> userList = historyRepository.findAll();
		return userList;
	}
	
	@Override
	public List<PaymentHistory> showMyHistory(String accountNumber, String pincode) {
    List<PaymentHistory> historyList=historyRepository.findAllByAccountNumber(accountNumber);
    
    if(historyList==null) {
    	throw new NullValueException("No history yet");
    }
    
    return historyList;
    
	}

	/*@Override
	public String createAccount(CreateAccountDTO dto) throws RegistrationException {

		Optional<UsersAccount> checkUser = accountRepository.findByAccountNumber(dto.getAccountNumber());

		if (checkUser.isPresent()) {
			throw new RegistrationException("Account Number already exists,unable to deposit");
		}

		// UsersAccount account = modelMapper.map(dto, UsersAccount.class);
		UsersAccount account = new UsersAccount();
		// account.setId(account.getId());
		account.setAccountHolderName(dto.getAccountHolderName());
		account.setAccountNumber(dto.getAccountNumber());
		account.setIdProofNo(dto.getIdProofNo());
		account.setIFSCCode(dto.getIFSCCode());
		account.setPhoneNo(dto.getPhoneNo());
		account.setPincode(dto.getPincode());
		// account.setAccBalance(0);
		account.setCreatedOn(new Date());
		accountRepository.save(account);

		PaymentHistory history = new PaymentHistory();
		history.setAccountNumber(dto.getAccountNumber());
		history.setCreatedOn(account.getCreatedOn());
		historyRepository.save(history);

		String jwt = jwtToken.tokenGenerator(account.getAccountId());

		jwtToken.parseJwtToken(jwt);
		return jwt;

	}

	@Override
	public void addBalanceToOwnAccount(String accountNumber, String ifscCode, double balance)
			throws RegistrationException, MismatchException {

		Optional<UsersAccount> checkUser = accountRepository.findByAccountNumber(accountNumber);

		if (!checkUser.isPresent()) {
			throw new RegistrationException("Account Number doesn't exist,unable to register");
		}

		if (!checkUser.get().getIFSCCode().equals(ifscCode)) {
			throw new MismatchException("given ifsc code doesn't match given account number");
		}

		UsersAccount account = checkUser.get();
		account.setAccBalance(checkUser.get().getAccBalance() + balance);

		accountRepository.save(account);
		Optional<PaymentHistory> history = historyRepository.findByAccountNumber(checkUser.get().getAccountNumber());

		history.get().setAmountDepositedOn(new Date());
		history.get().setAmountDeposited(balance);
		history.get().setCurrentBalance(account.getAccBalance());
		historyRepository.save(history.get());

	}

	@Override
	public void addBalanceToOthersAccount(String accountNumber, String accountHolderName, double amount,
			String senderAccountNumber) throws RegistrationException, MismatchException, InsufficientBalanceException {

		Optional<UsersAccount> checkSender = accountRepository.findByAccountNumber(senderAccountNumber);
		if (!checkSender.isPresent()) {
			throw new RegistrationException("Sender Account Number not available");
		}

		Optional<UsersAccount> checkReceiver = accountRepository.findByAccountNumber(accountNumber);

		if (!checkReceiver.isPresent()) {
			throw new RegistrationException("Receiver Account Number doesn't exists,unable to send");
		}

		if (!checkReceiver.get().getAccountHolderName().equals(accountHolderName)) {
			throw new MismatchException("given account number doesn't belong to above user");
		}

		UsersAccount senderAccount = checkSender.get();
		if (checkSender.get().getAccBalance() < amount) {
			throw new InsufficientBalanceException("you don't have enough account balance to proceed");
		}
		senderAccount.setAccBalance(checkSender.get().getAccBalance() - amount);

		accountRepository.save(senderAccount);

		UsersAccount receiverAccount = checkReceiver.get();
		receiverAccount.setAccBalance(checkReceiver.get().getAccBalance() + amount);

		accountRepository.save(receiverAccount);

		Optional<PaymentHistory> senderHistory = historyRepository
				.findByAccountNumber(checkSender.get().getAccountNumber());

		senderHistory.get().setAmountWithdrawnOn(new Date());
		senderHistory.get().setAmountWithdrawn(amount);
		senderHistory.get().setAmountSentTo(checkReceiver.get().getAccountHolderName());
		senderHistory.get().setCurrentBalance(senderAccount.getAccBalance());
		historyRepository.save(senderHistory.get());

		Optional<PaymentHistory> receiverHistory = historyRepository
				.findByAccountNumber(checkReceiver.get().getAccountNumber());

		receiverHistory.get().setAmountDepositedOn(new Date());
		receiverHistory.get().setAmountDeposited(amount);
		receiverHistory.get().setAmountReceivedFrom(checkSender.get().getAccountHolderName());
		receiverHistory.get().setCurrentBalance(receiverAccount.getAccBalance());
		historyRepository.save(receiverHistory.get());
	}

	@Override
	public void withdrawBalance(String accountNumber, double balance, String pincode)
			throws RegistrationException, MismatchException {

		Optional<UsersAccount> checkUser = accountRepository.findByAccountNumber(accountNumber);

		if (!checkUser.isPresent()) {
			throw new RegistrationException("Account Number doesn't exist,enter valid account number");
		}

		if (!checkUser.get().getPincode().equals(pincode)) {
			throw new MismatchException("pincode code error");
		}
		
		if(checkUser.get().getAccBalance()<balance) {
			throw new MismatchException("insufficient balance in account");
		}

		UsersAccount account = checkUser.get();
		account.setAccBalance(checkUser.get().getAccBalance() - balance);

		accountRepository.save(account);

		Optional<PaymentHistory> withdrawnHistory = historyRepository
				.findByAccountNumber(checkUser.get().getAccountNumber());

		withdrawnHistory.get().setAmountWithdrawnOn(new Date());
		withdrawnHistory.get().setAmountWithdrawn(balance);
		withdrawnHistory.get().setCurrentBalance(account.getAccBalance());

		historyRepository.save(withdrawnHistory.get());
	}

	@Override
	public double checkBalance(String accountNumber, String pincode) throws RegistrationException, MismatchException {
		Optional<UsersAccount> checkUser = accountRepository.findByAccountNumber(accountNumber);

		if (!checkUser.isPresent()) {
			throw new RegistrationException("Account Number doesn't exist,enter valid account number");
		}

		if (!checkUser.get().getPincode().equals(pincode)) {
			throw new MismatchException("pincode code error");
		}

		return checkUser.get().getAccBalance();
	}
*/
	

}
