package com.websystique.springmvc.dao;

import java.util.Date;
import java.util.List;

import com.websystique.springmvc.model.TaskPlan;

public interface TaskPlanDao {

	List<TaskPlan> findBySsoId(String ssoId, Date startDate, Date endDate);
	
	TaskPlan findById(int selectedId);
	
	List<Object[]> findAllTaskPlanJoined(String ssoId, Date startDate, Date endDate);
	
	void update(String ssoId, int taskId, int taskDetailId);
	
	void updateTaskPlan(TaskPlan taskPlan);
}
