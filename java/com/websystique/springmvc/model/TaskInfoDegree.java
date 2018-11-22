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
@Table(name="TASKINFODEGREE")
public class TaskInfoDegree implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="TASKINFOID", nullable=false)
	private Integer taskInfoId;
	
	@NotNull
	@Column(name="TASKID", nullable=false)
	private Integer taskId;
	
	@NotNull
	@Column(name="TASKDETAILID", nullable=false)
	private Integer taskDetailId;

	@NotNull
	@Column(name="TASKINFOGENERALDEGREE", nullable=false)
	private Integer taskInfoGeneralDegree;
	
	@NotNull
	@Column(name="TASKINFOGENERALPERCENTAGE", nullable=false)
	private Double taskInfoGeneralPercentage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTaskInfoId() {
		return taskInfoId;
	}

	public void setTaskInfoId(Integer taskInfoId) {
		this.taskInfoId = taskInfoId;
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

	public Integer getTaskInfoGeneralDegree() {
		return taskInfoGeneralDegree;
	}

	public void setTaskInfoGeneralDegree(Integer taskInfoGeneralDegree) {
		this.taskInfoGeneralDegree = taskInfoGeneralDegree;
	}

	public Double getTaskInfoGeneralPercentage() {
		return taskInfoGeneralPercentage;
	}

	public void setTaskInfoGeneralPercentage(Double taskInfoGeneralPercentage) {
		this.taskInfoGeneralPercentage = taskInfoGeneralPercentage;
	}
	

	
}
