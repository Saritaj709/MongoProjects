package com.capgemini.microservices.payment.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.microservices.payment.model.UsersAccount;

@Repository
public interface AccountRepository extends MongoRepository<UsersAccount,String> {
public Optional<UsersAccount> findByAccountNumber(String accountNumber);
	
}
