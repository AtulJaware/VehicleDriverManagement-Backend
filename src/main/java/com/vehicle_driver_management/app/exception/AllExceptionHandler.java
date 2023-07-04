package com.vehicle_driver_management.app.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vehicle_driver_management.app.entity.ErrorResponse;

@ControllerAdvice
public class AllExceptionHandler {
	@ExceptionHandler(LoginInvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> handleException(LoginInvalidCredentialsException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.BAD_REQUEST.value()); // 400 Bad Request
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);  // 400 Bad Request
	}
	
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleException(EmailNotFoundException exception) {
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
}
