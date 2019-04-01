package com.capgemini.microservices.user.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.microservices.user.model.Complain;

@Repository
public interface UserComplainRepository extends MongoRepository<Complain,String>{
public Optional<Complain> findByEmail(String email);
public void deleteByComplainId(String complainId);
public void deleteByProductName(String productName);
public void deleteByProductNameAndEmail(String productName, String userEmail);
}