package com.wellsfargo.sba3.its.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.wellsfargo.sba3.its.exceptions.ItsException;


@RestControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(ItsException.class)
	public ResponseEntity<String> handleItsException(ItsException exception) {
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception exception) {
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}