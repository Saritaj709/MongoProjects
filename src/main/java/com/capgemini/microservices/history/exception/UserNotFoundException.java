package com.capgemini.microservices.history.exception;

public class UserNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(final String message) {
		super(message);
	}
}
