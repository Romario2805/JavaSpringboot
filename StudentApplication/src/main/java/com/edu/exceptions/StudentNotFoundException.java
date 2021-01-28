package com.edu.exceptions;

public class StudentNotFoundException extends RuntimeException {
	
	public StudentNotFoundException()
	{
		
	}
	 
	public StudentNotFoundException(String message)
	{
	      super(message);	
	}

	public StudentNotFoundException(Throwable cause)
	{
		super(cause);
	}
}
