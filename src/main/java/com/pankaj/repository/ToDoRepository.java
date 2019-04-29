package com.pankaj.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pankaj.dto.Task;

@Repository
public interface ToDoRepository extends CrudRepository<Task, Long> {

}