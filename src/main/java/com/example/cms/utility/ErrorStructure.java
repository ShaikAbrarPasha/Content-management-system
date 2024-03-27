package com.example.cms.utility;

import org.springframework.stereotype.Component;

@Component
public class ErrorStructure <T>{

	private int statusCode;
	private String errorMessage;
	private T rootCause;

	public int getStatusCode() {
		return statusCode;
	}
	public ErrorStructure<T> setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public ErrorStructure<T> setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

	public Object getRootCause() {
		return rootCause;
	}
	public ErrorStructure<T> setRootCause(T rootCause) {
		this.rootCause = rootCause;
		return this;
	}

}
