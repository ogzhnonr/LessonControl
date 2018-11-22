package com.websystique.springmvc.model;

import java.io.Serializable;

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
@Table(name="TASKINFO")
public class TaskInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer taskInfoId;
	
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
	
	@Column(name="TASKSELFSTUDYDESC")
	private String taskSelfStudyDesc;
	
	@Column(name="TASKBEENSTUDIED")
	private boolean taskBeenStudied;
	
	@Column(name="TASKBEENSTUDIEDDESC")
	private String taskBeenStudiedDesc;
	
	@Column(name="TASKPRACTICEQUESTIONNUM")
	private Integer taskPracticeQuestionNum;
	
	@Column(name="TASKPRACTICERIGHTNUM")
	private Integer taskPracticeRightNum;
	
	@Column(name="TASKPRACTICEWRONGNUM")
	private Integer taskPracticeWrongNum;
	
	@Column(name="TASKPRACTICEDURATION")
	private Integer taskPracticeDuration;
	
	@Column(name="TASKPRACTICELESSONTOBESTUDY")
	private Integer taskPracticeLessonToBeStudy;
	
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

	public Integer getTaskInfoId() {
		return taskInfoId;
	}

	public void setTaskInfoId(Integer taskInfoId) {
		this.taskInfoId = taskInfoId;
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

	public String getTaskSelfStudyDesc() {
		return taskSelfStudyDesc;
	}

	public void setTaskSelfStudyDesc(String taskSelfStudyDesc) {
		this.taskSelfStudyDesc = taskSelfStudyDesc;
	}
	
	public boolean isTaskBeenStudied() {
		return taskBeenStudied;
	}

	public void setTaskBeenStudied(boolean taskBeenStudied) {
		this.taskBeenStudied = taskBeenStudied;
	}

	public String getTaskBeenStudiedDesc() {
		return taskBeenStudiedDesc;
	}

	public void setTaskBeenStudiedDesc(String taskBeenStudiedDesc) {
		this.taskBeenStudiedDesc = taskBeenStudiedDesc;
	}

	public Integer getTaskPracticeQuestionNum() {
		return taskPracticeQuestionNum;
	}

	public void setTaskPracticeQuestionNum(Integer taskPracticeQuestionNum) {
		this.taskPracticeQuestionNum = taskPracticeQuestionNum;
	}

	public Integer getTaskPracticeRightNum() {
		return taskPracticeRightNum;
	}

	public void setTaskPracticeRightNum(Integer taskPracticeRightNum) {
		this.taskPracticeRightNum = taskPracticeRightNum;
	}

	public Integer getTaskPracticeWrongNum() {
		return taskPracticeWrongNum;
	}

	public void setTaskPracticeWrongNum(Integer taskPracticeWrongNum) {
		this.taskPracticeWrongNum = taskPracticeWrongNum;
	}

	public Integer getTaskPracticeDuration() {
		return taskPracticeDuration;
	}

	public void setTaskPracticeDuration(Integer taskPracticeDuration) {
		this.taskPracticeDuration = taskPracticeDuration;
	}

	public Integer getTaskPracticeLessonToBeStudy() {
		return taskPracticeLessonToBeStudy;
	}

	public void setTaskPracticeLessonToBeStudy(Integer taskPracticeLessonToBeStudy) {
		this.taskPracticeLessonToBeStudy = taskPracticeLessonToBeStudy;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
		result = prime * result + ((taskInfoId == null) ? 0 : taskInfoId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Task))
			return false;
		TaskInfo other = (TaskInfo) obj;
		if (taskId == null) {
			if (other.taskId != null)
				return false;
		} else if (!taskId.equals(other.taskId))
			return false;
		if (taskInfoId == null) {
			if (other.taskInfoId != null)
				return false;
		} else if (!taskInfoId.equals(other.taskInfoId))
			return false;
		return true;
	}

	/*
	 * DO-NOT-INCLUDE passwords in toString function.
	 * It is done here just for convenience purpose.
	 */
	@Override
	public String toString() {
		return "TaskInfo [taskId=" + taskId + ", taskInfoId=" + taskInfoId 
				+ ", taskSelfStudy=" + taskSelfStudy
				+ ", taskSelfStudyDesc=" + taskSelfStudyDesc
				+ ", taskBeenStudied=" + taskBeenStudied
				+ ", taskBeenStudiedDesc=" + taskBeenStudiedDesc
				+ ", taskPracticeQuestionNum=" + taskPracticeQuestionNum
				+ ", taskPracticeRightNum=" + taskPracticeRightNum
				+ ", taskPracticeWrongNum=" + taskPracticeWrongNum
				+ ", taskPracticeDuration=" + taskPracticeDuration
				+ ", taskPracticeLessonToBeStudy=" + taskPracticeLessonToBeStudy
				+ "]";
	}

}
