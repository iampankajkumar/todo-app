package com.pankaj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pankaj.constants.TaskStatus;
import com.pankaj.dto.Task;
import com.pankaj.repository.ToDoRepository;

@Service
public class ToDoServiceImpl implements ToDoService {

	private ToDoRepository repository;

	@Autowired
	public ToDoServiceImpl(ToDoRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public void createTask(Task task) {
		task.setTaskStatus(TaskStatus.PENDING);
		repository.save(task);
	}

	@Override
	public List<Task> getTaskList() {
		return (List<Task>) repository.findAll();
	}

	@Override
	public Task getTask(Long taskId) {
		return repository.findOne(taskId);
	}

	@Override
	@Transactional
	public Task update(Task task, Long taskId) {
		task.setTaskStatus(TaskStatus.PENDING);
		return repository.save(task);
	}

	@Override
	@Transactional
	public void deleteTaskById(Long taskId) {
		repository.delete(taskId);
	}

	@Override
	@Transactional
	public Task updateTask(Task task) {
		Task tsk = getTask(task.getTaskId());
		tsk.setTaskStatus(task.getTaskStatus());
		return repository.save(tsk);
	}

}
