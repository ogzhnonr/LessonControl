package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.TaskMilestone;

@Repository("taskMilestoneDao")
public class TaskMilestoneDaoImpl extends AbstractDao<Integer, TaskMilestone> implements TaskMilestoneDao {

	@Override
	public TaskMilestone findBySsoId(int ssoId) {
		TaskMilestone taskMilestone = getByKey(ssoId);
		if (taskMilestone != null)
			Hibernate.initialize(taskMilestone);
		return taskMilestone;
	}

	@Override
	public TaskMilestone findByDenemeId(int denemeId) {
		TaskMilestone taskMilestone = getByKey(denemeId);
		if (taskMilestone != null)
			Hibernate.initialize(taskMilestone);
		return taskMilestone;
	}

	@Override
	public void save(TaskMilestone taskMilestone) {
		persist(taskMilestone);
	}

	@Override
	public void deleteBySsoId(int ssoId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", ssoId));
		TaskMilestone taskMilestone = (TaskMilestone)crit.uniqueResult();
		delete(taskMilestone);
	}

	@Override
	public void deleteByDenemeId(String userName, int denemeId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("denemeId", denemeId));
		crit.add(Restrictions.eq("ssoId", userName));
		TaskMilestone taskMilestone = (TaskMilestone)crit.uniqueResult();
		delete(taskMilestone);
	}
	
	@SuppressWarnings("unchecked")
	public TaskMilestone getLastTaskMilestoneBySsoId(String ssoId) {
		Criteria criteria = createEntityCriteria().addOrder(Order.desc("id"));
		criteria.add(Restrictions.eq("ssoId", ssoId));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
//		criteria.setFirstResult(0);
//		criteria.setMaxResults(1);
		List<TaskMilestone> taskMilestones = (List<TaskMilestone>) criteria.list();
		
		if (taskMilestones.size() == 0)
			return null;
		else
			return taskMilestones.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskMilestone> findAllTaskmilestones(String ssoId) {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.add(Restrictions.eq("ssoId", ssoId));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<TaskMilestone> taskMilestones = (List<TaskMilestone>) criteria.list();
		
		return taskMilestones;
	}
	
	

}
