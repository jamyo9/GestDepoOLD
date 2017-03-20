package com.gestdepo.model.exception;

public class NoUserException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NoUserException(String message) {
		super(message);
	}
	
	public NoUserException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
