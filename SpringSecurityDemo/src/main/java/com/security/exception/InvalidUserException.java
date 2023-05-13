package com.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidUserException extends RuntimeException{
	
	String message = "Invalid username";

	public InvalidUserException() {}
	
	public InvalidUserException(String message) {
		super();
		this.message = message;
	}
	
	@Override
	public String toString() {
		return message;
	}

}
