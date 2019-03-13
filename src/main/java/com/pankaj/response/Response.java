package com.pankaj.response;

import java.io.Serializable;

import com.pankaj.exception.ToDoStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response implements Serializable {
	private static final long serialVersionUID = 1L;

	private int code;
	private String message;
	private transient Object data;

	public Response(ToDoStatus error) {
		this.code = error.value();
		this.message = error.getMessage();
	}

	public Response(ToDoStatus error, Object data) {
		this.code = error.value();
		this.message = error.getMessage();
		this.data = data;
	}
}