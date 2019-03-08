package com.pankaj.exception;

public enum ToDoStatus {

	OK(200, "OK"), GENERAL_EXCEPTION_ERROR(1002, "Some Internal Error !"), NO_TASK_FOUND(404, "No Task Found !!");

	private final int value;
	private final String message;

	ToDoStatus(Integer value, String message) {
		this.value = value;
		this.message = message;
	}

	public Integer value() {
		return this.value;
	}

	public String getMessage() {
		return this.message;
	}

	@Override
	public String toString() {
		return Integer.toString(this.value);
	}
}
