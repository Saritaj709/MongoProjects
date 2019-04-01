package com.capgemini.microservices.history.exception;

public class InsufficientBalanceException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public InsufficientBalanceException(final String message) {
    	super(message);
    }
}
