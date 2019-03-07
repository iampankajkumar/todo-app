package com.pankaj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pankaj.dto.Task;

@Service
public interface ToDoService {

	public void createTask(Task task);

	public List<Task> getTaskList();

	public Task getTask(Long id);

	public Task update(Task task, Long taskId);

	public void deleteTaskById(Long taskId);

	public Task updateTask(Task task);
}
