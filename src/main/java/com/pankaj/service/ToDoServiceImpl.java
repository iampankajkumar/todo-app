package com.pankaj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pankaj.constants.TaskStatus;
import com.pankaj.dto.Task;
import com.pankaj.repository.ToDoRepository;

@Service
@Transactional
public class ToDoServiceImpl implements ToDoService {

	private ToDoRepository repository;

	@Autowired
	public ToDoServiceImpl(ToDoRepository repository) {
		this.repository = repository;
	}

	@Override
	public void createTask(Task task) {
		task.setTaskStatus(TaskStatus.PENDING.name());
		repository.save(task);
	}

	@Override
	public List<Task> getTaskList() {
		return (List<Task>) repository.findAll();
	}

	@Override
	public Task getTask(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Task update(Task task, Long taskId) {
		task.setTaskStatus(TaskStatus.PENDING.name());
		return repository.save(task);
	}

	@Override
	public void deleteTaskById(Long taskId) {
		repository.deleteById(taskId);
	}

	@Override
	public Task markAsDone(Long taskId) {
		Task tsk = getTask(taskId);
		tsk.setTaskStatus(TaskStatus.DONE.name());
		return repository.save(tsk);
	}

}
