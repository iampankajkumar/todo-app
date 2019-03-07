package com.pankaj.constants;

public enum TaskStatus {

	PENDING("PENDING"), DONE("DONE"), DELETED("DELETED");

	private final String statusCode;

	TaskStatus(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusCode() {
		return this.statusCode;
	}
}
