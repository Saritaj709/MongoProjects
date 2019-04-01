package com.capgemini.microservices.admin.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.microservices.admin.model.PaymentHistory;

@Repository
public interface HistoryRepository extends MongoRepository<PaymentHistory,String>{

	Optional<PaymentHistory> findByAccountNumber(String accountNumber);

	List<PaymentHistory> findAllByAccountNumber(String accountNumber);

}