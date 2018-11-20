package com.websystique.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.dao.TaskDetailDao;
import com.websystique.springmvc.dao.TaskInfoDao;
import com.websystique.springmvc.model.TaskInfo;

@Service("taskInfoService")
@Transactional
public class TaskInfoServiceImpl implements TaskInfoService {
	
	@Autowired
	TaskInfoDao dao;

	@Autowired
	TaskDetailDao taskDetailDao;
	
	@Override
	public TaskInfo findByTaskInfoId(int taskInfoId)
	{
		return dao.findByTaskInfoId(taskInfoId);
	}
	
	@Override
	public void save(TaskInfo taskInfo)
	{
		dao.save(taskInfo);
	}
	
	@Override
	public void deleteByTaskInfoId(String userName, int taskInfoId)
	{
		dao.deleteByTaskInfoId(userName, taskInfoId);
	}
	
	@Override
	public List<TaskInfo> findAllTaskInfo(String userName)
	{
		return dao.findAllTaskInfo(userName);
	}
	
	public List<Object[]> findAllTaskInfoJoined(String userName)
	{
		return dao.findAllTaskInfoJoined(userName);
	}
}

