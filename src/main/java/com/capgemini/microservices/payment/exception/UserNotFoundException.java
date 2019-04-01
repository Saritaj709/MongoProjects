package com.capgemini.microservices.payment.exception;

public class UserNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(final String message) {
		super(message);
	}
}
