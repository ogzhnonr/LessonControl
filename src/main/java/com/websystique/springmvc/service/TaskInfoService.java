package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.TaskInfo;

public interface TaskInfoService {

	TaskInfo findByTaskInfoId(int taskInfoId);
	
	void save(TaskInfo taskInfo);
	
	void deleteByTaskInfoId(String userName, int taskInfoId);
	
	List<TaskInfo> findAllTaskInfo(String userName);
	
	List<Object[]> findAllTaskInfoJoined(String userName);
}
