package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.TaskMilestone;
import com.websystique.springmvc.model.TaskMilestoneDegree;

@Repository("taskMilestoneDegreeDao")
public class TaskMilestoneDegreeDaoImpl extends AbstractDao<Integer, TaskMilestoneDegree> implements TaskMilestoneDegreeDao {

	@Override
	public TaskMilestoneDegree findBySsoId(int ssoId) {
		TaskMilestoneDegree taskMilestoneDegree = getByKey(ssoId);
		if (taskMilestoneDegree != null)
			Hibernate.initialize(taskMilestoneDegree);
		return taskMilestoneDegree;
	}

	@Override
	public TaskMilestoneDegree findByDenemeId(int denemeId) {
		TaskMilestoneDegree taskMilestoneDegree = getByKey(denemeId);
		if (taskMilestoneDegree != null)
			Hibernate.initialize(taskMilestoneDegree);
		return taskMilestoneDegree;
	}

	@Override
	public void save(TaskMilestoneDegree taskMilestoneDegree) {
		persist(taskMilestoneDegree);
	}

	@Override
	public void deleteBySsoId(int ssoId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", ssoId));
		TaskMilestoneDegree taskMilestoneDegree = (TaskMilestoneDegree)crit.uniqueResult();
		delete(taskMilestoneDegree);
	}

	@Override
	public void deleteByDenemeId(int denemeId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("denemeId", denemeId));
		TaskMilestoneDegree taskMilestoneDegree = (TaskMilestoneDegree)crit.uniqueResult();
		delete(taskMilestoneDegree);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskMilestoneDegree> findAllTaskMilestoneDegreesBySsoId() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<TaskMilestoneDegree> taskMilestoneDegrees = (List<TaskMilestoneDegree>) criteria.list();
		
		return taskMilestoneDegrees;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<TaskMilestoneDegree> findAllTaskMilestoneDegreesByDenemeId() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("denemeId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<TaskMilestoneDegree> taskMilestoneDegrees = (List<TaskMilestoneDegree>) criteria.list();
		
		return taskMilestoneDegrees;
	}

}
