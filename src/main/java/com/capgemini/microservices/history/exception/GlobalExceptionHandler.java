package com.capgemini.microservices.history.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.microservices.history.controller.HistoryController;
import com.capgemini.microservices.history.model.ResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	public static final Logger logger = LoggerFactory.getLogger(HistoryController.class);

	@ExceptionHandler(RegistrationException.class)
	public ResponseEntity<ResponseDTO> register(RegistrationException e) {
		logger.error("Registration exception");
		ResponseDTO response = new ResponseDTO();
		response.setMessage("Registration error " + e.getMessage());
		response.setStatus(1101);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ResponseDTO> login(LoginException e) {
		logger.error("Login exception");
		ResponseDTO response = new ResponseDTO();
		response.setMessage("Login error, " + e.getMessage());
		response.setStatus(1102);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseDTO> userNotFoundExceptionHandler(UserNotFoundException e) {
		logger.error("User not found exception");
		ResponseDTO response = new ResponseDTO();
		response.setMessage("User not found Exception, " + e.getMessage());
		response.setStatus(1103);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MismatchException.class)
	public ResponseEntity<ResponseDTO> activationExceptionHandler(MismatchException e) {
		logger.error("User account values mismatch exception");
		ResponseDTO response = new ResponseDTO();
		response.setMessage("User account values mismatch Exception, " + e.getMessage());
		response.setStatus(1104);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<ResponseDTO> insufficientBalanceExceptionHandler(InsufficientBalanceException e) {
		logger.error("Insufficient balance exception");
		ResponseDTO response = new ResponseDTO();
		response.setMessage("Insufficient balance exception, " + e.getMessage());
		response.setStatus(1106);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NullValueException.class)
	public ResponseEntity<ResponseDTO> nullValueException(NullValueException e) {
		logger.error("null value exception");
		ResponseDTO response = new ResponseDTO();
		response.setMessage("null value exception, " + e.getMessage());
		response.setStatus(1107);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	/*
	 * @ExceptionHandler(Exception.class) public ResponseEntity<ResponseDTO>
	 * controller(Exception e) { logger.error("other exceptions"); ResponseDTO
	 * response=new ResponseDTO();
	 * response.setMessage("Some exceptions occured, "+e.getMessage());
	 * response.setStatus(-1); return new
	 * ResponseEntity<>(response,HttpStatus.BAD_REQUEST); }
	 */
}