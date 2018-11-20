package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.TaskInfoDegree;

public interface TaskInfoDegreeService {
	
	TaskInfoDegree findByTaskInfoId(int taskInfoId);
	
	TaskInfoDegree findByTaskId(int taskId);
	
	TaskInfoDegree findByTaskDetaiId(int taskDetailId);
	
	void save(TaskInfoDegree taskInfoDegree);
	
	void deleteByTaskInfoId(int taskInfoId);
	
	void deleteByTaskId(int taskId);
	
	void deleteByTaskDetaiId(int taskDetailId);
	
	List<TaskInfoDegree> findAllTaskInfoDegreesByTaskInfoId();
	
	List<TaskInfoDegree> findAllTaskInfoDegreesByTaskId();
	
	List<TaskInfoDegree> findAllTaskInfoDegreesByTaskDetailId();


}
