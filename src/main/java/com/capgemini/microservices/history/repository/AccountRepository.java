package com.capgemini.microservices.history.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.microservices.history.model.UsersAccount;

@Repository
public interface AccountRepository extends MongoRepository<UsersAccount,String> {
public Optional<UsersAccount> findByAccountNumber(String accountNumber);
	
}
