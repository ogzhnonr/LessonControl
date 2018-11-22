package com.websystique.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TASKDETAIL")
public class TaskDetail implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(name="TASKID", nullable=false)
	private Integer taskId;
	
	@NotNull
	@Column(name="TASKDETAILID", nullable=false)
	private Integer taskDetailId;
		
	@NotNull
	@Column(name="TASKDETAILNAME", nullable=false)
	private String taskDetailName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getTaskDetailId() {
		return taskDetailId;
	}

	public void setTaskDetailId(Integer taskDetailId) {
		this.taskDetailId = taskDetailId;
	}

	public String getTaskDetailName() {
		return taskDetailName;
	}

	public void setTaskDetailName(String taskDetailName) {
		this.taskDetailName = taskDetailName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
		result = prime * result + ((taskDetailName == null) ? 0 : taskDetailId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		TaskDetail other = (TaskDetail) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (taskId == null) {
			if (other.taskId != null)
				return false;
		} else if (!taskId.equals(other.taskId))
			return false;
		return true;
	}

	/*
	 * DO-NOT-INCLUDE passwords in toString function.
	 * It is done here just for convenience purpose.
	 */
	@Override
	public String toString() {
		return "TaskDetail [id=" + id + ", taskId=" + taskId + "]";
	}

}
