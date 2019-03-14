package com.pankaj.service;

import org.springframework.stereotype.Service;

import com.pankaj.dto.Task;
import com.pankaj.response.Response;

@Service
public interface ToDoService {

	public Response createTask(Task task);

	public Response getTaskList();

	public Response getTask(Long id);

	public Response update(Task task, Long taskId);

	public Response deleteTaskById(Long taskId);

	public Response updateTask(Task task);
}
