package com.pankaj.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pankaj.constants.TaskStatus;
import com.pankaj.dto.Task;
import com.pankaj.exception.ToDoStatus;
import com.pankaj.repository.ToDoRepository;
import com.pankaj.response.Response;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ToDoServiceTest {

	@Mock
	private ToDoRepository repository;

	@InjectMocks
	ToDoServiceImpl service;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_createTask() {
		log.info("<<<<< ::::: create task [START] ::::: >>>>>");
		Task task = new Task(3l, "This is test task", TaskStatus.PENDING);
		Response response = new Response(ToDoStatus.OK, task);
		when(repository.findOne(1l)).thenReturn((Task) response.getData());
		Response actualResp = service.createTask(task);
		assertEquals(actualResp, response);
		verify(repository, times(1)).save(task);
		log.info("<<<<< ::::: create task [END] ::::: >>>>>");
	}

	@Test
	public void test_getTask() {
		log.info("<<<<< ::::: Getting Task [START] ::::: >>>>>");
		Task task = new Task(1l, "This is created task", TaskStatus.PENDING);
		Response response = new Response(ToDoStatus.OK, task);
		when(repository.findOne(1l)).thenReturn((Task) response.getData());

		Response actualResp = service.getTask(1l);
		assertEquals(response, actualResp);
		verify(repository, times(1)).findOne(1l);
		log.info("<<<<< ::::: Getting Task [END] ::::: >>>>>");

	}

	@Test
	@SuppressWarnings("unchecked")
	public void test_getTaskList() {
		log.info("<<<<< ::::: Getting Task List [START] ::::: >>>>>");
		List<Task> list = new ArrayList<Task>();
		list.add(new Task(1l, "This is my Task 1", TaskStatus.PENDING));
		list.add(new Task(2l, "This is my task 2", TaskStatus.PENDING));
		list.add(new Task(3l, "This is my task 3", TaskStatus.PENDING));
		Response reseponse = new Response(ToDoStatus.OK, list);
		when(repository.findAll()).thenReturn((Iterable<Task>) reseponse.getData());
		// test
		List<Task> taskList = (List<Task>) service.getTaskList().getData();
		assertEquals(3, taskList.size());
		verify(repository, times(1)).findAll();
		log.info("<<<<< ::::: Getting Task List [END] ::::: >>>>>");
	}

	@Test
	public void test_updateTask() {
		log.info("<<<<< ::::: Task updation [START]");
		Task task = new Task(1l, "This is my Task 1", TaskStatus.PENDING);
		Response response = new Response(ToDoStatus.OK, task);
		when(repository.findOne(1l)).thenReturn((Task) response.getData());
		task.setTaskStatus(TaskStatus.DONE);
		when(repository.save(task)).thenReturn((Task) response.getData());
		Response actualResponse = service.update(task, 1l);
		assertEquals(response, actualResponse);
		verify(repository, times(1)).save(task);
		log.info("<<<<< ::::: Task updation [END]");
	}

	@Test
	public void test_deleteTask() {

	}
}
