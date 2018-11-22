package com.websystique.springmvc.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.Task;

@Repository("taskDao")
public class TaskDaoImpl extends AbstractDao<Integer, Task> implements TaskDao {

	static final Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);
	
	@Override
	public Task findByTaskId(int taskId) {
		Task task = getByKey(taskId);
		if(task!=null){
			Hibernate.initialize(task.getTaskId());
		}
		return task;
	}

	@Override
	public Task findByParentId(int parentId) {
		Task task = getByKey(parentId);
		if(task!=null){
			Hibernate.initialize(task.getTaskId());
		}
		return task;
	}

	@Override
	public void save(Task task) {
		persist(task);
	}

	@Override
	public void deleteByTaskId(int taskId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("taskId", taskId));
		Task task = (Task)crit.uniqueResult();
		delete(task);
	}

	@Override
	public void deleteByParentId(int parentId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("parentId", parentId));
		Task task = (Task)crit.uniqueResult();
		delete(task);
	}

	@SuppressWarnings("unchecked")
	public List<Task> findAllTasks() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("taskId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Task> tasks = (List<Task>) criteria.list();
		
		// No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
		// Uncomment below lines for eagerly fetching of userProfiles if you want.
		/*
		for(User user : users){
			Hibernate.initialize(user.getUserProfiles());
		}*/
		return tasks;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<Object, Object> findAllTasksForDropdown() {
		HashMap<Object, Object> tasks = new HashMap<Object, Object>();
		
		Criteria criteria = createEntityCriteria()
				.addOrder(Order.asc("taskId"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
		List<Task> list = criteria.list();
		Iterator<Task> itr = list.iterator();
		while(itr.hasNext())
		{
			Task task = itr.next();
			tasks.put(task.getTaskId(), task.getTaskName());
		} 
		
		return tasks;
	}

}
