package com.pankaj.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pankaj.dto.Task;

@Repository
public interface ToDoRepository extends CrudRepository<Task, Long> {

	@Modifying
	@Query("update Task t set t.taskStatus='DELETED' WHERE t.taskId = :taskId")
	void deleteById(@Param("taskId") Long taskId);
}