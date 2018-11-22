package com.websystique.springmvc.service;

import java.util.HashMap;
import java.util.List;

import com.websystique.springmvc.model.TaskDetail;

public interface TaskDetailService {
	
	TaskDetail findByTaskId(int taskId);
	
	TaskDetail findByTaskDetailId(int taskDetailId);
	
	void save(TaskDetail taskDetail);
	
	void deleteByTaskId(int taskId);
	
	void deleteByTaskDetailId(int taskDetailId);
	
	List<TaskDetail> findAllTaskDetails();
	
	List<TaskDetail> findAllTaskDetailForDropdown(Integer taskId);
}
