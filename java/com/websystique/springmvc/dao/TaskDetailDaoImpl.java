package com.websystique.springmvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.TaskDetail;

@Repository("taskDetailDao")
public class TaskDetailDaoImpl extends AbstractDao<Integer, TaskDetail> implements TaskDetailDao {

	static final Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);

	@Override
	public TaskDetail findByTaskId(int taskId) {
		TaskDetail taskDetail = getByKey(taskId);
		if (taskDetail != null)
			Hibernate.initialize(taskDetail);
		return taskDetail;
	}

	@Override
	public TaskDetail findByTaskDetailId(int taskDetailId) {
		TaskDetail taskDetail = getByKey(taskDetailId);
		if (taskDetail != null)
			Hibernate.initialize(taskDetail);
		return taskDetail;
	}

	@Override
	public void save(TaskDetail taskDetail) {
		persist(taskDetail);
	}

	@Override
	public void deleteByTaskId(int taskId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("taskId", taskId));
		TaskDetail taskDetail =(TaskDetail)crit.uniqueResult();
		delete(taskDetail);
	}

	@Override
	public void deleteByTaskDetailId(int taskDetailId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eqOrIsNull("taskDetailId", taskDetailId));
		TaskDetail taskDetail = (TaskDetail)crit.uniqueResult();
		delete(taskDetail);
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	@Override
	public List<TaskDetail> findAllTaskDetails() {
		Criteria crit = createEntityCriteria().addOrder(Order.asc("taskId"));
		ResultTransformer rt = crit.DISTINCT_ROOT_ENTITY;
		crit.setResultTransformer(rt);
		List<TaskDetail> list = (List<TaskDetail>) crit.list();
		
		return list;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<TaskDetail> findAllTaskDetailForDropdown(Integer taskId) {
		Criteria criteria = createEntityCriteria()
				.add(Restrictions.eqOrIsNull("taskId", taskId))
				.addOrder(Order.asc("taskDetailId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<TaskDetail> taskDetails = criteria.list();
		
		return taskDetails;
	}
	
	@Override
	public TaskDetail findTaskDetailByTaskIdAndTaskDetailId(Integer taskId, Integer taskDetailId) {
		Criteria criteria = createEntityCriteria()
				.add(Restrictions.eqOrIsNull("taskId", taskId))
				.add(Restrictions.eqOrIsNull("taskDetailId", taskDetailId))
				.addOrder(Order.asc("taskDetailId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		TaskDetail taskDetail =(TaskDetail)criteria.uniqueResult();
		
		return taskDetail;
	}

}
