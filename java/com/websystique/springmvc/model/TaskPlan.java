package com.websystique.springmvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TASKPLAN")
public class TaskPlan implements Serializable {

private static final long serialVersionUID = 1L;
	
	/**
	 * id
	 */
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="SSOID", nullable=false)
	private String ssoId;
	
	@NotNull
	@Column(name="TASKID", nullable=false)
	private Integer taskId;
	
	@NotNull
	@Column(name="TASKDETAILID", nullable=false)
	private Integer taskDetailId;
	
	@Column(name="TASKSELFSTUDY")
	private boolean taskSelfStudy;
	
	@Column(name="TASKBEENSTUDIED")
	private boolean taskBeenStudied;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="DESCRIPTIONDETAIL")
	private String descriptionDetail;
	
	@Column(name="STATUS")
	private Integer status;
	
	@Column(name="STARTDATE")
	private Date startDate;
	
	@Column(name="ENDDATE")
	private Date endDate;
	
	@ManyToOne//(targetEntity=Task.class, fetch=FetchType.LAZY, optional=true)
    @JoinColumn(name="taskId", referencedColumnName="taskId", insertable = false, updatable = false) //
	//@Cascade({CascadeType.DETACH})
	private Task task;
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@ManyToOne//(fetch=FetchType.EAGER)//targetEntity=TaskDetail.class, fetch=FetchType.LAZY, optional=true
	//@JoinColumn(name="taskId", referencedColumnName="taskId", insertable = false, updatable = false) //
	@JoinColumns({
		@JoinColumn(name="taskId", referencedColumnName="taskId", insertable = false, updatable = false),
		@JoinColumn(name="taskDetailId", referencedColumnName="taskDetailId", insertable = false, updatable = false)
    })
	//@JoinColumn(name="taskDetailId", referencedColumnName="taskDetailName")
	//@Cascade({CascadeType.ALL})
    private TaskDetail taskDetail;
	
	public TaskDetail getTaskDetail() {
		return taskDetail;
	}

	public void setTaskDetail(TaskDetail taskDetail) {
		this.taskDetail = taskDetail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
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

	public boolean isTaskSelfStudy() {
		return taskSelfStudy;
	}

	public void setTaskSelfStudy(boolean taskSelfStudy) {
		this.taskSelfStudy = taskSelfStudy;
	}

	public boolean isTaskBeenStudied() {
		return taskBeenStudied;
	}

	public void setTaskBeenStudied(boolean taskBeenStudied) {
		this.taskBeenStudied = taskBeenStudied;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionDetail() {
		return descriptionDetail;
	}

	public void setDescriptionDetail(String descriptionDetail) {
		this.descriptionDetail = descriptionDetail;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
