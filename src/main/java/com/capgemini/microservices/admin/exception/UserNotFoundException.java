package com.capgemini.microservices.admin.exception;

public class UserNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(final String message) {
		super(message);
	}
}
