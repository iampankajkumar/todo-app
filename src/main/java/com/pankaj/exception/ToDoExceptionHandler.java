package com.pankaj.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pankaj.response.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ToDoExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ToDoException.class)
	@ResponseBody
	protected Response handleExceptionToDo(ToDoException ex) {
		log.error(ex.getMessage(), ex);
		return new Response(ex.getStatus());
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	protected Response handleGeneralException(Exception ex) {
		log.error(ex.getMessage(), ex);
		return new Response(ToDoStatus.GENERAL_EXCEPTION_ERROR);
	}

}
