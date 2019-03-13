package com.pankaj.service;

import org.springframework.stereotype.Service;

import com.pankaj.dto.Task;
import com.pankaj.exception.ToDoException;
import com.pankaj.response.Response;

@Service
public interface ToDoService {

	public Response createTask(Task task);

	public Response getTaskList() throws ToDoException;

	public Response getTask(Long id) throws ToDoException;

	public Response update(Task task, Long taskId) throws ToDoException;

	public Response deleteTaskById(Long taskId) throws ToDoException;

	public Response updateTask(Task task) throws ToDoException;
}
