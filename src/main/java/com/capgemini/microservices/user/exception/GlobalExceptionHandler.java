package com.capgemini.microservices.user.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.microservices.user.controller.UserComplaintsController;
import com.capgemini.microservices.user.model.ResponseDTO;

@ControllerAdvice
public class GlobalExceptionHandler {

	public static final Logger logger = LoggerFactory.getLogger(UserComplaintsController.class);
	
	@ExceptionHandler(RegistrationException.class)
	public ResponseEntity<ResponseDTO> register(RegistrationException e){
		logger.error("Registration exception");
		ResponseDTO response=new ResponseDTO();
		response.setMessage("Registration error "+e.getMessage());
		response.setStatus(1101);
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseDTO> userNotFoundExceptionHandler(UserNotFoundException e){
		logger.error("User not found exception");
		ResponseDTO response=new ResponseDTO();
		response.setMessage("User not found Exception, "+e.getMessage());
		response.setStatus(1103);
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UnAuthorizedException.class)
	public ResponseEntity<ResponseDTO> unAuthorizedExceptionHandler(UnAuthorizedException e){
		logger.error("User unauthoried exception");
		ResponseDTO response=new ResponseDTO();
		response.setMessage("User unauthorized Exception, "+e.getMessage());
		response.setStatus(1104);
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NullValueException.class)
	public ResponseEntity<ResponseDTO> nullValueExceptionHandler(NullValueException e){
		logger.error("null value exception");
		ResponseDTO response=new ResponseDTO();
		response.setMessage("null value Exception, "+e.getMessage());
		response.setStatus(1104);
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}

	
	
	/*@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> controller(Exception e) {
		logger.error("other exceptions");
		ResponseDTO response=new ResponseDTO();
		response.setMessage("Some exceptions occured, "+e.getMessage());
		response.setStatus(-1);
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}*/
}
