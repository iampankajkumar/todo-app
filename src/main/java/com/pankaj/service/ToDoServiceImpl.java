package com.pankaj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pankaj.constants.TaskStatus;
import com.pankaj.dto.Task;
import com.pankaj.exception.ToDoException;
import com.pankaj.exception.ToDoStatus;
import com.pankaj.repository.ToDoRepository;
import com.pankaj.response.Response;

@Service
public class ToDoServiceImpl implements ToDoService {

	private ToDoRepository repository;

	@Autowired
	public ToDoServiceImpl(ToDoRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Response createTask(Task task) {
		task.setTaskStatus(TaskStatus.PENDING);
		return new Response(ToDoStatus.OK, repository.save(task));
	}

	@Override
	public Response getTaskList() {
		List<Task> taskList = (List<Task>) repository.findAll();
		if (taskList == null || taskList.isEmpty())
			throw new ToDoException(ToDoStatus.NO_TASK_FOUND);
		return new Response(ToDoStatus.OK, taskList);
	}

	@Override
	public Response getTask(Long taskId) {
		Task task = repository.findOne(taskId);
		if (task == null)
			throw new ToDoException(ToDoStatus.NO_TASK_FOUND);
		System.out.println(task);
		return new Response(ToDoStatus.OK, task);
	}

	@Override
	@Transactional
	public Response update(Task task, Long taskId) {
		task.setTaskStatus(TaskStatus.PENDING);
		return new Response(ToDoStatus.OK, repository.save(task));
	}

	@Override
	@Transactional
	public Response deleteTaskById(Long taskId) {
		repository.delete(taskId);
		return new Response(ToDoStatus.OK);
	}

	@Override
	@Transactional
	public Response updateTask(Task task) {
		Task tsk = repository.findOne(task.getTaskId());
		tsk.setTaskStatus(task.getTaskStatus());
		return new Response(ToDoStatus.OK, repository.save(tsk));
	}

}
