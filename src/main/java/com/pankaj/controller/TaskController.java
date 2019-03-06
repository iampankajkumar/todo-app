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
import com.pankaj.service.ToDoService;

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
	public void createTask(@RequestBody Task task) {
		log.info("<<<<< :::::Creating a task !!::::: >>>>>");
		service.createTask(task);
	}

	@GetMapping(path = "/tasks")
	public List<Task> getTaskList() {
		log.info("<<<<< :::::Getting all task list !!::::: >>>>>");
		return service.getTaskList();
	}

	@GetMapping(path = "/tasks/{taskId}")
	public Task getTaskList(@PathVariable long taskId) {
		log.info("<<<<< :::::Getting all task list !!::::: >>>>>");
		return service.getTask(taskId);
	}

	@DeleteMapping(path = "/tasks/{taskId}")
	public void deleteTask(@PathVariable("taskId") long taskId) {
		log.info("<<<<< :::::Deleteing a task !!::::: >>>>>");
		service.deleteTaskById(taskId);
	}

	@PutMapping(path = "/tasks/{taskId}")
	public void markAsDone(@PathVariable("taskId") Long taskId) {
		service.markAsDone(taskId);
	}
}
