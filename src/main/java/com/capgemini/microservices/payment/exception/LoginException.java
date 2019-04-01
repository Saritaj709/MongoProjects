package com.capgemini.microservices.payment.exception;

public class LoginException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public LoginException(String message) {
    	super(message);
    }
}
