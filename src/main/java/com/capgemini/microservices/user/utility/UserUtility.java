package com.capgemini.microservices.user.utility;

import java.util.UUID;

import com.capgemini.microservices.user.exception.RegistrationException;
import com.capgemini.microservices.user.model.ComplainDTO;

public class UserUtility {

	private final static String EMAIL = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$";

	public static void validateUser(ComplainDTO complain) throws RegistrationException {
		if (!complain.getEmail().matches(EMAIL)) {
			throw new RegistrationException("User email is not valid ,follow abc@gmail.com,abc.100@yahoo.com");
		} else if (complain.getComplain().length()==0) {
			throw new RegistrationException("User complain cannot be null");
		} 
	}

	public static String generateUUId(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
}
