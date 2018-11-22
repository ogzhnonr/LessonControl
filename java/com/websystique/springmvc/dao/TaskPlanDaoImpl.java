package com.websystique.springmvc.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.DateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.websystique.springmvc.model.TaskPlan;
import com.websystique.springmvc.model.User;

@Repository
public class TaskPlanDaoImpl extends AbstractDao<String, TaskPlan> implements TaskPlanDao {
	
	static final Logger logger = LoggerFactory.getLogger(TaskInfoDaoImpl.class);
	
	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPlan> findBySsoId(String ssoId, Date startDate, Date endDate){
		
		Criteria crt = createEntityCriteria();
		crt.add(Restrictions.eq("ssoId", ssoId));
		crt.add(Restrictions.eq("startDate", startDate));
		crt.add(Restrictions.eq("endDate", endDate));
		List<TaskPlan> taskPlanList = (List<TaskPlan>)crt.list();
		
		return taskPlanList;
	}
	
	@Override
	public TaskPlan findById(int selectedId){
		Criteria crt = createEntityCriteria();
		crt.add(Restrictions.eq("id", selectedId));
		TaskPlan taskPlan = (TaskPlan)crt.uniqueResult();
		
		return taskPlan;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> findAllTaskPlanJoined(String ssoId, Date startDate, Date endDate)
	{
		Session session = getSession();
		
		Query q = session.createQuery("select "
										+ "t.taskName, td.taskDetailName, tp.id, tp.ssoId, "
										+ "tp.taskId, tp.taskDetailId, tp.taskSelfStudy, tp.taskBeenStudied, "
										+ "tp.description, tp.descriptionDetail, tp.status, tp.startDate, tp.endDate "
										+ "from TaskPlan as tp "
										+ "inner join tp.task as t "// on t.taskId = ti.taskId "
										+ "inner join tp.taskDetail as td "
										+ "where tp.taskId = t.taskId "
										+ "and tp.taskId = td.taskId and tp.taskDetailId = td.taskDetailId "
										+ "and tp.ssoId = \'" + ssoId + "\' "
										+ "and tp.startDate >= :startDateParam  "
										//+ "and tp.endDate <= :endDateParam "
										+ "order by tp.startDate");// on td.taskId = ti.taskId ");
		
		q.setParameter("startDateParam", startDate, DateType.INSTANCE);
		//q.setParameter("endDateParam", endDate);
		
//		q.setDate("startDateParam", startDate);
//		q.setDate("endDateParam", endDate);
		
		List<Object[]> taskPlanJoined = q.list();
		
		return taskPlanJoined;
	}
	
	@Override
	public void update(String ssoId, int taskId, int taskDetailId){
		
	}
	
	/*
	 * Since the method is running with Transaction, No need to call hibernate update explicitly.
	 * Just fetch the entity from db and update it with proper values within transaction.
	 * It will be updated in db once transaction ends. 
	 */
	@Override
	public void updateTaskPlan(TaskPlan taskPlan){
		
		TaskPlan entity = findById(taskPlan.getId());

		if (entity == null){
			entity = new TaskPlan();
		}
		
		//TODO:ogz Listeleme yapýldýktan sonra null kontrolu açýlacak ve saveOrUpdate update olarak güncellenecek		
		//if (entity != null){
			entity.setDescription(taskPlan.getDescription());
			entity.setDescriptionDetail(taskPlan.getDescriptionDetail());
			entity.setEndDate(taskPlan.getEndDate());
			entity.setId(taskPlan.getId());
			entity.setSsoId(taskPlan.getSsoId());
			entity.setStartDate(taskPlan.getStartDate());
			entity.setStatus(taskPlan.getStatus());
			entity.setTaskDetailId(taskPlan.getTaskDetailId());
			entity.setTaskId(taskPlan.getTaskId());
			entity.setTaskBeenStudied(taskPlan.isTaskBeenStudied());
			entity.setTaskSelfStudy(taskPlan.isTaskSelfStudy());
			
			saveOrUpdate(entity);
		//}
		
	}
	
}
