package com.pankaj.exception;

public class ToDoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ToDoException() {
		super();
	}

	public ToDoException(String message) {
		super(message);
	}

	public ToDoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ToDoException(Throwable cause) {
		super(cause);
	}

}
