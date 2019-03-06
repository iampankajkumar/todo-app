package com.pankaj.service;

import java.util.List;

import com.pankaj.dto.Task;

public interface ToDoService {

	public void createTask(Task task);

	public List<Task> getTaskList();

	public Task getTask(Long id);

	public Task update(Task task, Long taskId);

	public void deleteTaskById(Long taskId);

	public Task markAsDone(Long taskId);
}
