package com.capgemini.microservices.payment.services;

import java.util.List;

import com.capgemini.microservices.payment.exception.InsufficientBalanceException;
import com.capgemini.microservices.payment.exception.MismatchException;
import com.capgemini.microservices.payment.exception.RegistrationException;
import com.capgemini.microservices.payment.model.CreateAccountDTO;
import com.capgemini.microservices.payment.model.PaymentHistory;
import com.capgemini.microservices.payment.model.UsersAccount;

public interface PaymentService {
	String createAccount(CreateAccountDTO dto) throws RegistrationException;

	void addBalanceToOwnAccount(String accountNumber, String ifscCode, double balance)
			throws RegistrationException, MismatchException;

	List<UsersAccount> getAllUsers();

	void addBalanceToOthersAccount(String accountNumber, String accountHolderName, double amount,
			String senderAccountNumber) throws RegistrationException, MismatchException, InsufficientBalanceException;

	void withdrawBalance(String accountNumber, double balance, String pincode)
			throws RegistrationException, MismatchException;

	double checkBalance(String accountNumber, String pincode) throws RegistrationException, MismatchException;

	List<PaymentHistory> getAllPaymentHistory();
}
