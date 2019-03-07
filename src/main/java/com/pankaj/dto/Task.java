package com.pankaj.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.pankaj.constants.TaskStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Task")
@Data
@NoArgsConstructor
@SQLDelete(sql = "update Task set task_status='DELETED' WHERE task_id = ?")
@Where(clause = "task_status <> 'DELETED'")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id", updatable = false)
	private Long taskId;

	@Column(name = "task_description", nullable = false)
	private String taskDesc;

	@Enumerated(EnumType.STRING)
	@Column(name = "task_status", nullable = false, length = 10)
	private TaskStatus taskStatus;

}
