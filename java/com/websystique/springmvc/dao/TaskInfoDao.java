package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.websystique.springmvc.model.TaskInfo;

public interface TaskInfoDao {
	
	TaskInfo findByTaskInfoId(int taskInfoId);
	
	void save(TaskInfo taskInfo);
	
	void deleteByTaskInfoId(String userName, int taskInfoId);
	
	List<TaskInfo> findAllTaskInfo(String userName);
	
	List<Object[]> findAllTaskInfoJoined(String userName);

}
