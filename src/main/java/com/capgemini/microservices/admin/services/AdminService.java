package com.capgemini.microservices.admin.services;

import java.util.List;

import com.capgemini.microservices.admin.model.PaymentHistory;
import com.capgemini.microservices.admin.model.User;
import com.capgemini.microservices.admin.model.UsersAccount;

public interface AdminService {
	List<UsersAccount> getAllAccountUsers();

	List<PaymentHistory> getAllPaymentHistory();

	List<User> getAllUsers();
	//List<PaymentHistory> showMyHistory(String accountNumber, String pincode);

}
