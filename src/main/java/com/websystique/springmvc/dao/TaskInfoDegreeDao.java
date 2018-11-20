package com.websystique.springmvc.dao;

import java.util.List;

import com.websystique.springmvc.model.TaskInfoDegree;

public interface TaskInfoDegreeDao {
	
	TaskInfoDegree findByTaskInfoId(int taskInfoId);
	
	TaskInfoDegree findByTaskId(int taskId);
	
	TaskInfoDegree findByTaskDetailId(int taskDetailId);
	
	void save(TaskInfoDegree taskInfoDegree);
	
	void deleteByTaskInfoId(int taskInfoId);
	
	void deleteByTaskId(int taskId);
	
	void deleteByTaskDetailId(int taskDetailId);
	
	List<TaskInfoDegree> findAllTaskInfoDegreesByTaskInfoId();
	
	List<TaskInfoDegree> findAllTaskInfoDegreesByTaskId();
	
	List<TaskInfoDegree> findAllTaskInfoDegreesByTaskDetailId();

}
