package com.websystique.springmvc.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.TaskDetailDao;
import com.websystique.springmvc.model.TaskDetail;

@Service("taskDetailService")
@Transactional
public class TaskDetailServiceImpl implements TaskDetailService {

	@Autowired
	TaskDetailDao dao;
	
	@Override
	public TaskDetail findByTaskId(int taskId) {
		return dao.findByTaskId(taskId);
	}

	@Override
	public TaskDetail findByTaskDetailId(int taskDetailId) {
		return dao.findByTaskDetailId(taskDetailId);
	}

	@Override
	public void save(TaskDetail taskDetail) {
		dao.save(taskDetail);
	}

	@Override
	public void deleteByTaskId(int taskId) {
		dao.deleteByTaskId(taskId);
	}

	@Override
	public void deleteByTaskDetailId(int taskDetailId) {
		dao.deleteByTaskDetailId(taskDetailId);
	}

	@Override
	public List<TaskDetail> findAllTaskDetails() {
		return dao.findAllTaskDetails();
	}
	
	@Override
	public List<TaskDetail> findAllTaskDetailForDropdown(Integer taskId) {
		return dao.findAllTaskDetailForDropdown(taskId);
	}

}
