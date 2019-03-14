package com.pankaj.controller;

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
import com.pankaj.response.Response;
import com.pankaj.service.ToDoService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/api")
public class TaskController {

	private ToDoService service;

	@Autowired
	public TaskController(ToDoService service) {
		this.service = service;
	}

	@PostMapping(path = "/tasks")
	@ApiOperation(value = "This API creates a task")
	public Response createTask(@RequestBody Task task){
		log.info("<<<<< :::::Creating a task !!::::: >>>>>");
		return service.createTask(task);
	}

	@GetMapping(path = "/tasks")
	@ApiOperation(value = "This API gets list of tasks")
	public Response getTaskList(){
		log.info("<<<<< :::::Getting all task list !!::::: >>>>>");
		return service.getTaskList();
	}

	@GetMapping(path = "/tasks/{taskId}")
	@ApiOperation(value = "This API gets task for particular Id")
	public Response getTaskList(@PathVariable Long taskId){
		log.info("<<<<< :::::Getting all task list !!::::: >>>>>");
		return service.getTask(taskId);
	}

	@DeleteMapping(path = "/tasks/{taskId}")
	@ApiOperation(value = "This API delete task for particular Id")
	public Response deleteTask(@PathVariable("taskId") Long taskId){
		log.info("<<<<< :::::Deleteing a task !!::::: >>>>>");
		return service.deleteTaskById(taskId);
	}

	@PutMapping(path = "/tasks")
	@ApiOperation(value = "This API update a task status")
	public Response updateTask(@RequestBody Task task){
		return service.updateTask(task);
	}
}