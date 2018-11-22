package com.websystique.springmvc.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.dao.TaskMilestoneDao;
import com.websystique.springmvc.model.TaskMilestone;

@Service("taskMilestoneService")
@Transactional
public class TaskMilestoneServiceImpl implements TaskMilestoneService{
	
	@Autowired
	TaskMilestoneDao dao;

	@Override
	public TaskMilestone findBySsoId(int ssoId) {
		// TODO Auto-generated method stub
		return dao.findBySsoId(ssoId);
	}

	@Override
	public TaskMilestone findByDenemeId(int denemeId) {
		// TODO Auto-generated method stub
		return dao.findByDenemeId(denemeId);
	}

	@Override
	public void save(TaskMilestone taskMilestone) {
		// TODO Auto-generated method stub
		dao.save(taskMilestone);
	}

	@Override
	public void deleteBySsoId(int ssoId) {
		// TODO Auto-generated method stub
		dao.deleteBySsoId(ssoId);
	}

	@Override
	public void deleteByDenemeId(String userName, int denemeId) {
		// TODO Auto-generated method stub
		dao.deleteByDenemeId(userName, denemeId);
	}
	
	@Override
	public TaskMilestone getLastTaskMilestoneBySsoId(String ssoId) {
		return dao.getLastTaskMilestoneBySsoId(ssoId);
	}

	@Override
	public List<TaskMilestone> findAllTaskmilestones(String ssoId) {
		// TODO Auto-generated method stub
		return dao.findAllTaskmilestones(ssoId);
	}
	
	

}
