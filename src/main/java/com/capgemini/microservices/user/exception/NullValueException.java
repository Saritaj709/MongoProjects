package com.capgemini.microservices.user.exception;

public class NullValueException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NullValueException(final String message) {
		super(message);
	}

}
