package com.websystique.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.TaskMilestoneDegreeDao;
import com.websystique.springmvc.model.TaskMilestoneDegree;

@Service("taskMilestoneDegreeService")
@Transactional
public class TaskMilestoneDegreeServiceImpl implements TaskMilestoneDegreeService{
	
	@Autowired
	TaskMilestoneDegreeDao dao;

	@Override
	public TaskMilestoneDegree findBySsoId(int ssoId) {
		// TODO Auto-generated method stub
		return dao.findBySsoId(ssoId);
	}

	@Override
	public TaskMilestoneDegree findByDenemeId(int denemeId) {
		// TODO Auto-generated method stub
		return dao.findByDenemeId(denemeId);
	}

	@Override
	public void save(TaskMilestoneDegree taskMilestoneDegree) {
		// TODO Auto-generated method stub
		dao.save(taskMilestoneDegree);
	}

	@Override
	public void deleteBySsoId(int ssoId) {
		// TODO Auto-generated method stub
		dao.deleteBySsoId(ssoId);
	}

	@Override
	public void deleteByDenemeId(int denemeId) {
		// TODO Auto-generated method stub
		dao.deleteByDenemeId(denemeId);
	}

	@Override
	public List<TaskMilestoneDegree> findAllTaskMilestoneDegreesBySsoId() {
		// TODO Auto-generated method stub
		return dao.findAllTaskMilestoneDegreesBySsoId();
	}
	
	@Override
	public List<TaskMilestoneDegree> findAllTaskMilestoneDegreesByDenemeId() {
		// TODO Auto-generated method stub
		return dao.findAllTaskMilestoneDegreesByDenemeId();
	}
	
	

}
