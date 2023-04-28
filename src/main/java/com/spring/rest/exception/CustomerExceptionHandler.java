package com.spring.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.rest.entity.Error;

@ControllerAdvice
public class CustomerExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<Error> customerNotFound(CustomerNotFound e){
		Error error = new Error(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<Error> customerErrorHandler(Exception e){
		return new ResponseEntity<>(new Error(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis()),HttpStatus.BAD_REQUEST);
	}
	
}
