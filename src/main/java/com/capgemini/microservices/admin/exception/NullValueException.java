package com.capgemini.microservices.admin.exception;

public class NullValueException extends RuntimeException {
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public NullValueException(final String message) {
	 super(message);
 }
}
