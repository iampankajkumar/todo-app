package com.pankaj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pankaj.dto.Task;
import com.pankaj.exception.ToDoException;
import com.pankaj.exception.ToDoStatus;
import com.pankaj.response.Response;
import com.pankaj.service.ToDoService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api")
//@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

	private ToDoService service;

	@Autowired
	public TaskController(ToDoService service) {
		this.service = service;
	}

	@PostMapping(path = "/tasks")
	@ApiOperation(value = "This API creates a task")
	public Response createTask(@RequestBody Task task) throws ToDoException {
		log.info("<<<<< :::::Creating a task !!::::: >>>>>");
		service.createTask(task);
		return new Response(ToDoStatus.OK);
	}

	@GetMapping(path = "/tasks")
	@ApiOperation(value = "This API gets list of tasks")
	public Response getTaskList() throws ToDoException {
		log.info("<<<<< :::::Getting all task list !!::::: >>>>>");
		List<Task> taskList = service.getTaskList();
		if (taskList == null || taskList.isEmpty())
			throw new ToDoException(ToDoStatus.NO_TASK_FOUND);
		return new Response(ToDoStatus.OK, service.getTaskList());
	}

	@GetMapping(path = "/tasks/{taskId}")
	@ApiOperation(value = "This API gets task for particular Id")
	public Response getTaskList(@PathVariable Long taskId) throws ToDoException {
		log.info("<<<<< :::::Getting all task list !!::::: >>>>>");
		if (service.getTask(taskId) == null)
			throw new ToDoException(ToDoStatus.NO_TASK_FOUND);
		return new Response(ToDoStatus.OK, service.getTask(taskId));
	}

	@DeleteMapping(path = "/tasks/{taskId}")
	@ApiOperation(value = "This API delete task for particular Id")
	public Response deleteTask(@PathVariable("taskId") Long taskId) throws ToDoException {
		log.info("<<<<< :::::Deleteing a task !!::::: >>>>>");
		service.deleteTaskById(taskId);
		return new Response(ToDoStatus.OK);
	}

	@PutMapping(path = "/tasks")
	@ApiOperation(value = "This API update a task status")
	public Response updateTask(@RequestBody Task task) throws ToDoException {
		service.updateTask(task);
		return new Response(ToDoStatus.OK);
	}
}