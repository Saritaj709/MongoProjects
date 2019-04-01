package com.capgemini.microservices.history.services;

import java.util.List;

import com.capgemini.microservices.history.model.PaymentHistory;

public interface HistoryService {
List<PaymentHistory> getAllUsers();
List<PaymentHistory> showMyHistory(String accountNumber, String pincode);
}
