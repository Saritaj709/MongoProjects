/*package com.capgemini.microservices.payment.controller;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.capgemini.microservices.payment.model.PaymentHistory;

@FeignClient(serviceId = "PaymentService")
public interface PaymentHistoryProxy {

	@RequestMapping("/show-all-history/findAll")
	public List<PaymentHistory> getAllHistory();

	@RequestMapping("/show-my-history/{accountnumber}")
	public List<PaymentHistory> findByAccountNumber(@PathVariable(value = "accountNumber") String accountNumber);
}
*/