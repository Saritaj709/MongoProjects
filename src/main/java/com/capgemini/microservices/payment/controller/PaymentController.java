package com.capgemini.microservices.payment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.microservices.payment.exception.InsufficientBalanceException;
import com.capgemini.microservices.payment.exception.MismatchException;
import com.capgemini.microservices.payment.exception.RegistrationException;
import com.capgemini.microservices.payment.model.CreateAccountDTO;
import com.capgemini.microservices.payment.model.PaymentHistory;
import com.capgemini.microservices.payment.model.ResponseDTO;
import com.capgemini.microservices.payment.model.UsersAccount;
import com.capgemini.microservices.payment.services.PaymentService;

@RefreshScope
@RestController
//@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	// -------------Get All Users--------------------------

	@RequestMapping(value = "/check-users", method = RequestMethod.GET)
	public List<UsersAccount> getAllUsers() {
		return paymentService.getAllUsers();
	}

	// -----------------------Create-Account------------------------

	@RequestMapping(value = "/create-account", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> createAccount(@RequestBody CreateAccountDTO dto) throws RegistrationException {

		paymentService.createAccount(dto);

		ResponseDTO response = new ResponseDTO();
		response.setMessage("User account with contact " + dto.getPhoneNo() + " created successfully");
		response.setStatus(1);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// -------------------Add-Money-To-Own-Account------------------------
	@RequestMapping(value = "/add-Balance-to-own-account", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> addBalanceToOwnAccount(
			@RequestParam(value = "accountNumber") String accountNumber,
			@RequestParam(value = "ifscCode") String ifscCode, @RequestParam(value = "amount") double balance)
			throws RegistrationException, MismatchException {
		paymentService.addBalanceToOwnAccount(accountNumber, ifscCode, balance);

		ResponseDTO response = new ResponseDTO();
		response.setMessage("amount deposited to account number " + accountNumber);
		response.setStatus(2);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

	// ------------------Add-Money-To-Others-Account---------------------------

	@RequestMapping(value = "/add-Balance-to-others-account", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> addBalanceToOthersAccount(
			@RequestParam(value = "receiverAccountNumber") String receiverAccNumber,
			@RequestParam(value = "receiverAccountHolderName") String accountHolderName,
			@RequestParam(value = "amountToSend") double amount,
			@RequestParam(value = "senderAccountNumber") String senderAccNumber)
			throws RegistrationException, MismatchException, InsufficientBalanceException {
		paymentService.addBalanceToOthersAccount(receiverAccNumber, accountHolderName, amount, senderAccNumber);

		ResponseDTO response = new ResponseDTO();
		response.setMessage("amount deposited to account number " + receiverAccNumber);
		response.setStatus(3);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

	// -----------------Withdraw-Money----------------------------------------

	@RequestMapping(value = "/withdraw-balance", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> withdrawBalance(@RequestParam(value = "accountNumber") String accountNumber,
			@RequestParam(value = "balance") double balance, @RequestParam(value = "pincode") String pincode)
			throws RegistrationException, MismatchException, InsufficientBalanceException {
		paymentService.withdrawBalance(accountNumber, balance, pincode);

		ResponseDTO response = new ResponseDTO();
		response.setMessage("amount withdrawn from account number " + accountNumber);
		response.setStatus(4);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

	// ----------------Check-Balance-------------------------------------------
	@RequestMapping(value = "/check-balance", method = RequestMethod.POST)
	public ResponseEntity<ResponseDTO> checkBalance(@RequestParam(value = "accountNumber") String accountNumber,
			@RequestParam(value = "pincode") String pincode)
			throws RegistrationException, MismatchException, InsufficientBalanceException {
		double balance = paymentService.checkBalance(accountNumber, pincode);

		ResponseDTO response = new ResponseDTO();
		response.setMessage("your account balance is : " + balance);
		response.setStatus(5);
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
	}

	// -----------------Payment History------------------------------------------

	@RequestMapping(value = "/show-all-history/findAll", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentHistory>> getAllPaymentHistory() {
		return new ResponseEntity<>(paymentService.getAllPaymentHistory(), HttpStatus.ACCEPTED);
	}

}
