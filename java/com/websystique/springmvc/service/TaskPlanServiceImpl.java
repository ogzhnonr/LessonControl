package com.websystique.springmvc.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.TaskPlanDao;
import com.websystique.springmvc.model.TaskPlan;

@Service("taskPlanService")
@Transactional
public class TaskPlanServiceImpl implements TaskPlanService{
	
	@Autowired
	TaskPlanDao dao;
	
	@Override
	public List<TaskPlan> findBySsoId(String ssoId, Date startDate, Date endDate){
		
		return dao.findBySsoId(ssoId, startDate, endDate);
		
	}
	
	@Override
	public TaskPlan findById(int selectedId){
		
		return dao.findById(selectedId);
	
	}
	
	@Override
	public List<Object[]> findAllTaskPlanJoined(String ssoId, Date startDate, Date endDate){
		
		return dao.findAllTaskPlanJoined(ssoId, startDate, endDate);
		
	}
	
	@Override
	public void update(String ssoId, int taskId, int taskDetailId){
		
	}
	
	@Override
	public void updateTaskPlan(TaskPlan taskPlan){
		dao.updateTaskPlan(taskPlan);
	}

}
