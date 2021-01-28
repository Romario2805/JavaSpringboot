package com.edu.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException stnfex)
	{
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(stnfex.getMessage());
		errorResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(errorResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception ex)
	{
		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage(ex.getMessage());
		errorResponse.setTimestamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(errorResponse,HttpStatus.BAD_REQUEST);
	}

}
