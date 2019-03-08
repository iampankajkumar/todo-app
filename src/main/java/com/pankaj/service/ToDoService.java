package com.pankaj.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pankaj.dto.Task;
import com.pankaj.exception.ToDoException;

@Service
public interface ToDoService {

	public void createTask(Task task);

	public List<Task> getTaskList() throws ToDoException;

	public Task getTask(Long id) throws ToDoException;

	public Task update(Task task, Long taskId) throws ToDoException;

	public void deleteTaskById(Long taskId) throws ToDoException;

	public Task updateTask(Task task) throws ToDoException;
}
