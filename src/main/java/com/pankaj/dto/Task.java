package com.pankaj.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "Task")
@Data
@NoArgsConstructor
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private long taskId;

	@NonNull
	@Column(name = "task_description", nullable = false)
	private String taskDesc;

	@NonNull
	@Column(name = "task_status", nullable = false, length = 10)
	private String taskStatus;

}
