package com.pankaj.exception;

public class ToDoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private final ToDoStatus status;

	public ToDoException(ToDoStatus status) {
		super(status.getMessage());
		this.status = status;
	}

	public ToDoStatus getStatus() {
		return status;
	}

}