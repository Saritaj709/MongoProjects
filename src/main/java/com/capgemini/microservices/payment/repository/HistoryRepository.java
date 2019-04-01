package com.capgemini.microservices.payment.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.microservices.payment.model.PaymentHistory;

@Repository
public interface HistoryRepository extends MongoRepository<PaymentHistory,String>{

	Optional<PaymentHistory> findByAccountNumber(String accountNumber);

}
