package com.capgemini.microservices.user.services;

import java.util.List;

import com.capgemini.microservices.user.exception.NullValueException;
import com.capgemini.microservices.user.exception.RegistrationException;
import com.capgemini.microservices.user.exception.UnAuthorizedException;
import com.capgemini.microservices.user.exception.UserNotFoundException;
import com.capgemini.microservices.user.model.Complain;
import com.capgemini.microservices.user.model.ComplainDTO;

public interface ComplainService {
	public String registerComplain(ComplainDTO complain,String rootAccountpassword) throws UserNotFoundException, RegistrationException, UnAuthorizedException;

	public void deleteComplain(String complain,String userEmail,String rootAccountPassword) throws UserNotFoundException, UnAuthorizedException, NullValueException;

	public List<Complain> getAllComplaints();

}
