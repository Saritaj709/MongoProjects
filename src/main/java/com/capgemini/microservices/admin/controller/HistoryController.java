package com.capgemini.microservices.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.microservices.admin.model.PaymentHistory;
import com.capgemini.microservices.admin.model.User;
import com.capgemini.microservices.admin.model.UsersAccount;
import com.capgemini.microservices.admin.services.AdminService;

@RestController
@RequestMapping("/history")
public class HistoryController {

	@Autowired
	private AdminService adminService;

	public static final Logger logger = LoggerFactory.getLogger(HistoryController.class);

	// -------------Get All Users--------------------------

	@RequestMapping(value = "/check-users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		return new ResponseEntity<>(adminService.getAllUsers(), HttpStatus.OK);
	}

	// ----------------Get All Account Details--------------------
	@RequestMapping(value = "/check-accounts", method = RequestMethod.GET)
	public ResponseEntity<List<UsersAccount>> getAllAccountUsers() {
		return new ResponseEntity<>(adminService.getAllAccountUsers(), HttpStatus.OK);
	}

	// ---------------Get All Payment History----------------------

	@RequestMapping(value = "/check-payments", method = RequestMethod.GET)
	public ResponseEntity<List<PaymentHistory>> getAllPaymentHistory() {
		return new ResponseEntity<>(adminService.getAllPaymentHistory(), HttpStatus.OK);
	}

	/*
	 * //-----------------------Create-Account------------------------
	 * 
	 * @RequestMapping(value = "/create-account", method = RequestMethod.POST)
	 * public ResponseEntity<ResponseDTO> createAccount(@RequestBody
	 * CreateAccountDTO dto) throws RegistrationException {
	 * 
	 * historyService.createAccount(dto);
	 * 
	 * ResponseDTO response = new ResponseDTO();
	 * response.setMessage("User account with contact "+dto.getPhoneNo()
	 * +" created successfully"); response.setStatus(1);
	 * 
	 * return new ResponseEntity<>(response, HttpStatus.CREATED); }
	 */
	// ---------------------See-User-Payment-History-----------------------
	/*
	 * @RequestMapping(value="/show-my-history",method=RequestMethod.POST) public
	 * ResponseEntity<List<PaymentHistory>>
	 * showMyHistory(@RequestParam(value="accountNumber")String
	 * accountNumber,@RequestParam(value="pincode")String pincode){
	 * List<PaymentHistory>
	 * history=adminService.showMyHistory(accountNumber,pincode); return new
	 * ResponseEntity<>(history,HttpStatus.ACCEPTED); }
	 */
	/*
	 * //-------------------Add-Money-To-Own-Account------------------------
	 * 
	 * @RequestMapping(value="/add-Balance-to-own-account",method=RequestMethod.
	 * POST) public ResponseEntity<ResponseDTO>
	 * addBalanceToOwnAccount(@RequestParam(value="accountNumber")String
	 * accountNumber,@RequestParam(value="ifscCode") String
	 * ifscCode,@RequestParam(value="amount") double balance) throws
	 * RegistrationException, MismatchException {
	 * historyService.addBalanceToOwnAccount(accountNumber, ifscCode, balance);
	 * 
	 * ResponseDTO response=new ResponseDTO();
	 * response.setMessage("amount deposited to account number "+accountNumber);
	 * response.setStatus(2); return new
	 * ResponseEntity<>(response,HttpStatus.ACCEPTED); }
	 * 
	 * //------------------Add-Money-To-Others-Account---------------------------
	 * 
	 * @RequestMapping(value="/add-Balance-to-others-account",method=RequestMethod.
	 * POST) public ResponseEntity<ResponseDTO>
	 * addBalanceToOthersAccount(@RequestParam(value="receiverAccountNumber")String
	 * receiverAccNumber,@RequestParam(value="receiverAccountHolderName") String
	 * accountHolderName,@RequestParam(value="amountToSend") double amount,
	 * 
	 * @RequestParam(value="senderAccountNumber") String senderAccNumber) throws
	 * RegistrationException, MismatchException, InsufficientBalanceException {
	 * historyService.addBalanceToOthersAccount(receiverAccNumber,
	 * accountHolderName, amount, senderAccNumber);
	 * 
	 * ResponseDTO response=new ResponseDTO();
	 * response.setMessage("amount deposited to account number "+receiverAccNumber);
	 * response.setStatus(3); return new
	 * ResponseEntity<>(response,HttpStatus.ACCEPTED); }
	 * 
	 * //-----------------Withdraw-Money----------------------------------------
	 * 
	 * @RequestMapping(value="/withdraw-balance",method=RequestMethod.POST) public
	 * ResponseEntity<ResponseDTO>
	 * withdrawBalance(@RequestParam(value="accountNumber")String
	 * accountNumber,@RequestParam(value="balance")double
	 * balance,@RequestParam(value="pincode") String pincode) throws
	 * RegistrationException, MismatchException, InsufficientBalanceException {
	 * historyService.withdrawBalance(accountNumber, balance, pincode);
	 * 
	 * ResponseDTO response=new ResponseDTO();
	 * response.setMessage("amount withdrawn from account number "+accountNumber);
	 * response.setStatus(4); return new
	 * ResponseEntity<>(response,HttpStatus.ACCEPTED); }
	 * //----------------Check-Balance-------------------------------------------
	 * 
	 * @RequestMapping(value="/check-balance",method=RequestMethod.POST) public
	 * ResponseEntity<ResponseDTO>
	 * checkBalance(@RequestParam(value="accountNumber")String
	 * accountNumber,@RequestParam(value="pincode") String pincode) throws
	 * RegistrationException, MismatchException, InsufficientBalanceException {
	 * double balance=historyService.checkBalance(accountNumber, pincode);
	 * 
	 * ResponseDTO response=new ResponseDTO();
	 * response.setMessage("your account balance is : "+balance);
	 * response.setStatus(5); return new
	 * ResponseEntity<>(response,HttpStatus.ACCEPTED); }
	 */
}
