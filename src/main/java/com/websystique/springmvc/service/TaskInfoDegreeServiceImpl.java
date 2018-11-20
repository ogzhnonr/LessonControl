package com.websystique.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.TaskInfoDegreeDao;
import com.websystique.springmvc.model.TaskInfoDegree;

@Service("taskInfoDegreeService")
@Transactional
public class TaskInfoDegreeServiceImpl implements TaskInfoDegreeService {

	@Autowired
	TaskInfoDegreeDao dao;
	
	@Override
	public TaskInfoDegree findByTaskInfoId(int taskInfoId) {
		return dao.findByTaskInfoId(taskInfoId);
	}

	@Override
	public TaskInfoDegree findByTaskId(int taskId) {
		// TODO Auto-generated method stub
		return dao.findByTaskId(taskId);
	}

	@Override
	public TaskInfoDegree findByTaskDetaiId(int taskDetailId) {
		// TODO Auto-generated method stub
		return dao.findByTaskDetailId(taskDetailId);
	}

	@Override
	public void save(TaskInfoDegree taskInfoDegree) {
		// TODO Auto-generated method stub
		dao.save(taskInfoDegree);
	}

	@Override
	public void deleteByTaskInfoId(int taskInfoId) {
		// TODO Auto-generated method stub
		dao.deleteByTaskInfoId(taskInfoId);
	}

	@Override
	public void deleteByTaskId(int taskId) {
		// TODO Auto-generated method stub
		dao.deleteByTaskId(taskId);
	}

	@Override
	public void deleteByTaskDetaiId(int taskDetailId) {
		// TODO Auto-generated method stub
		dao.deleteByTaskDetailId(taskDetailId);
	}

	@Override
	public List<TaskInfoDegree> findAllTaskInfoDegreesByTaskInfoId() {
		// TODO Auto-generated method stub
		return dao.findAllTaskInfoDegreesByTaskInfoId();
	}

	@Override
	public List<TaskInfoDegree> findAllTaskInfoDegreesByTaskId() {
		// TODO Auto-generated method stub
		return dao.findAllTaskInfoDegreesByTaskId();
	}

	@Override
	public List<TaskInfoDegree> findAllTaskInfoDegreesByTaskDetailId() {
		// TODO Auto-generated method stub
		return dao.findAllTaskInfoDegreesByTaskDetailId();
	}

}
