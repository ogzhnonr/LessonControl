package com.websystique.springmvc.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.websystique.springmvc.model.Task;
import com.websystique.springmvc.model.TaskDetail;

public interface TaskDetailDao {
	
	TaskDetail findByTaskId(int taskId);
	
	TaskDetail findByTaskDetailId(int taskDetailId);
	
	void save(TaskDetail taskDetali);
	
	void deleteByTaskId(int taskId);
	
	void deleteByTaskDetailId(int taskDetailId);
	
	List<TaskDetail> findAllTaskDetails();

	List<TaskDetail> findAllTaskDetailForDropdown(Integer taskId);
	
	TaskDetail findTaskDetailByTaskIdAndTaskDetailId(Integer taskId, Integer taskDetailId);
}
