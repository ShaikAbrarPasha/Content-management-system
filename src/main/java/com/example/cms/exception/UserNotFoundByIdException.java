package com.example.cms.exception;

public class UserNotFoundByIdException {
	private String message;

	public UserNotFoundByIdException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
