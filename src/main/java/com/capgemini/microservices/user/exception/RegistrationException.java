package com.capgemini.microservices.user.exception;

public class RegistrationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public RegistrationException(final String message) {
    	super(message);
    }
}
