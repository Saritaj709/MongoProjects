package com.capgemini.microservices.history.controller;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(serviceId = "PaymentService")
public interface PaymentHistoryProxy {

	@RequestMapping("/show-all-history/findAll")
	public List<?> getAllHistory();

	@RequestMapping("/show-my-history/{accountnumber}")
	public List<?> findByAccountNumber(@PathVariable(value = "accountNumber") String accountNumber);
}
