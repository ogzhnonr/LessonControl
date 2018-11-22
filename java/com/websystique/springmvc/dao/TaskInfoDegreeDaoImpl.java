package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.TaskInfoDegree;
import com.websystique.springmvc.model.TaskMilestone;
import com.websystique.springmvc.model.TaskMilestoneDegree;

@Repository("taskInfoDegreeDao")
public class TaskInfoDegreeDaoImpl extends AbstractDao<Integer, TaskInfoDegree> implements TaskInfoDegreeDao {

	@Override
	public TaskInfoDegree findByTaskInfoId(int taskInfoId) {
		TaskInfoDegree taskInfoDegree = getByKey(taskInfoId);
		if (taskInfoDegree != null)
			Hibernate.initialize(taskInfoDegree);
		return taskInfoDegree;
	}

	@Override
	public TaskInfoDegree findByTaskId(int taskId) {
		TaskInfoDegree taskInfoDegree = getByKey(taskId);
		if (taskInfoDegree != null)
			Hibernate.initialize(taskInfoDegree);
		return taskInfoDegree;
	}
	
	@Override
	public TaskInfoDegree findByTaskDetailId(int taskDetailId) {
		TaskInfoDegree taskInfoDegree = getByKey(taskDetailId);
		if (taskInfoDegree != null)
			Hibernate.initialize(taskInfoDegree);
		return taskInfoDegree;
	}

	@Override
	public void save(TaskInfoDegree taskInfoDegree) {
		persist(taskInfoDegree);
	}

	@Override
	public void deleteByTaskInfoId(int taskInfoId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("taskInfoId", taskInfoId));
		TaskInfoDegree taskInfoDegree = (TaskInfoDegree)crit.uniqueResult();
		delete(taskInfoDegree);
	}

	@Override
	public void deleteByTaskId(int taskId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("taskId", taskId));
		TaskInfoDegree taskInfoDegree = (TaskInfoDegree)crit.uniqueResult();
		delete(taskInfoDegree);
	}
	
	@Override
	public void deleteByTaskDetailId(int taskDetailId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("taskDetailId", taskDetailId));
		TaskInfoDegree taskInfoDegree = (TaskInfoDegree)crit.uniqueResult();
		delete(taskInfoDegree);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskInfoDegree> findAllTaskInfoDegreesByTaskInfoId() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("taskInfoId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<TaskInfoDegree> taskInfoDegrees = (List<TaskInfoDegree>) criteria.list();
		
		return taskInfoDegrees;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<TaskInfoDegree> findAllTaskInfoDegreesByTaskId() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("taskId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<TaskInfoDegree> taskInfoDegrees = (List<TaskInfoDegree>) criteria.list();
		
		return taskInfoDegrees;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<TaskInfoDegree> findAllTaskInfoDegreesByTaskDetailId() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("taskDetailId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<TaskInfoDegree> taskInfoDegrees = (List<TaskInfoDegree>) criteria.list();
		
		return taskInfoDegrees;
	}

}
