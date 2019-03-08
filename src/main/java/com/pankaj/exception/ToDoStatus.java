package com.pankaj.exception;

public enum ToDoStatus {

	OK(200, "OK"), GENERAL_EXCEPTION_ERROR(1002, "Some Internal Error !"), NO_TASK_FOUND(404, "No Task Found !!");

	private final int value;

	private final String reasonPhrase;

	ToDoStatus(Integer value, String reasonPhrase) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
	}

	public Integer value() {
		return this.value;
	}

	public String getReasonPhrase() {
		return this.reasonPhrase;
	}

	@Override
	public String toString() {
		return Integer.toString(this.value);
	}
}
