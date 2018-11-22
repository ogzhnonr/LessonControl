package com.websystique.springmvc.service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.TaskDao;
import com.websystique.springmvc.model.Task;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDao dao;
	
	@Override
	public Task findByTaskId(int taskId) {
		return dao.findByTaskId(taskId);
	}

	@Override
	public Task findByParentId(int parentId) {
		return dao.findByParentId(parentId);
	}

	@Override
	public void save(Task task) {
		dao.save(task);
	}

	@Override
	public void deleteByTaskId(int taskId) {
		dao.deleteByTaskId(taskId);
	}

	@Override
	public void deleteByParentId(int parentId) {
		dao.deleteByParentId(parentId);
	}

	@Override
	public List<Task> findAllTasks() {
		return dao.findAllTasks();
	}

	@Override
	public HashMap<Object, Object> findAllTasksForDropdown() {
		// TODO Auto-generated method stub
		return dao.findAllTasksForDropdown();
	}
	
	

}
