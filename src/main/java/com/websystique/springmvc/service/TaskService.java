package com.websystique.springmvc.service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import com.websystique.springmvc.model.Task;

public interface TaskService {
	
	Task findByTaskId(int taskId);
	
	Task findByParentId(int parentId);
	
	void save(Task task);
	
	void deleteByTaskId(int taskId);
	
	void deleteByParentId(int parentId);
	
	List<Task> findAllTasks();
	
	HashMap<Object, Object> findAllTasksForDropdown();

}
