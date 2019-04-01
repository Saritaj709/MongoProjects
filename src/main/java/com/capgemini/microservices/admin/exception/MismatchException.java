package com.capgemini.microservices.admin.exception;

public class MismatchException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MismatchException(final String message) {
		super(message);
	}
}
