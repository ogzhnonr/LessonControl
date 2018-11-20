package com.websystique.springmvc.dao;

import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.websystique.springmvc.configuration.HibernateConfiguration;
import com.websystique.springmvc.model.Task;
import com.websystique.springmvc.model.TaskDetail;
import com.websystique.springmvc.model.TaskInfo;

@Repository("taskInfoDao")
public class TaskInfoDaoImpl extends AbstractDao<Integer, TaskInfo> implements TaskInfoDao {

	static final Logger logger = LoggerFactory.getLogger(TaskInfoDaoImpl.class);
	
	@Override
	public TaskInfo findByTaskInfoId(int taskInfoId)
	{
		TaskInfo taskInfo = getByKey(taskInfoId);
		if(taskInfo!=null)
		{
			Hibernate.initialize(taskInfo.getTaskInfoId());
		}
		return taskInfo;
	}
	
	@Override
	public void save(TaskInfo taskInfo)
	{
		TaskInfo tInfo = new TaskInfo();
		tInfo.setTaskInfoId(taskInfo.getTaskInfoId());
		tInfo.setSsoId(taskInfo.getSsoId());
		tInfo.setTaskId(taskInfo.getTaskId());
		tInfo.setTaskDetailId(taskInfo.getTaskDetailId());
		tInfo.setTaskBeenStudied(taskInfo.isTaskBeenStudied());
		tInfo.setTaskBeenStudiedDesc(taskInfo.getTaskBeenStudiedDesc());
		tInfo.setTaskPracticeDuration(taskInfo.getTaskPracticeDuration());
		tInfo.setTaskPracticeLessonToBeStudy(taskInfo.getTaskPracticeLessonToBeStudy());
		tInfo.setTaskPracticeQuestionNum(taskInfo.getTaskPracticeQuestionNum());
		tInfo.setTaskPracticeRightNum(taskInfo.getTaskPracticeRightNum());
		tInfo.setTaskPracticeWrongNum(taskInfo.getTaskPracticeWrongNum());
		tInfo.setTaskSelfStudy(taskInfo.isTaskSelfStudy());
		tInfo.setTaskSelfStudyDesc(taskInfo.getTaskSelfStudyDesc());
		//persist(taskInfo);
		persist(tInfo);
	}

	@Override
	public void deleteByTaskInfoId(String userName, int taskInfoId)
	{
		Criteria crt = createEntityCriteria();
		crt.add(Restrictions.eq("taskInfoId", taskInfoId));
		crt.add(Restrictions.eq("ssoId", userName));
		TaskInfo taskInfo = (TaskInfo)crt.uniqueResult();
		delete(taskInfo);
	}
	
	@SuppressWarnings("unchecked")
	public List<TaskInfo> findAllTaskInfo(String userName)
	{
		Criteria crt = createEntityCriteria().addOrder(Order.asc("taskInfoId"));
		crt.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		crt.add(Restrictions.eq("ssoId", userName));
		List<TaskInfo> taskInfo = (List<TaskInfo>) crt.list();
		return taskInfo;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> findAllTaskInfoJoined(String userName)
	{
		Session session = getSession();
//		Query q = session.createQuery("select "
//										+ "t.taskName, td.taskDetailName, ti.taskInfoId, ti.taskId, ti.taskDetailId, ti.taskSelfStudy, ti.taskSelfStudyDesc, ti.taskBeenStudied, "
//										+ "ti.taskBeenStudiedDesc, ti.taskPracticeQuestionNum, ti.taskPracticeRightNum, ti.taskPracticeWrongNum, "
//										+ "ti.taskPracticeDuration, ti.taskPracticeLessonToBeStudy "
//										+ "from TaskDetail as td "
//										+ "inner join td.Task as t "// on t.taskId = ti.taskId "
//										+ "inner join t.TaskInfo as ti "
//										+ "where ti.taskId = t.taskId and t.taskId=td.taskId "
//										+ "order by ti.taskInfoId");// on td.taskId = ti.taskId ");
//		String str = q.getQueryString();
//		List<Object[]> taskInfoJoined = q.list();
		
		Query q = session.createQuery("select "
										+ "t.taskName, td.taskDetailName, ti.taskInfoId, ti.taskId, ti.taskDetailId, ti.taskSelfStudy, ti.taskSelfStudyDesc, ti.taskBeenStudied, "
										+ "ti.taskBeenStudiedDesc, ti.taskPracticeQuestionNum, ti.taskPracticeRightNum, ti.taskPracticeWrongNum, "
										+ "ti.taskPracticeDuration, ti.taskPracticeLessonToBeStudy "
										+ "from TaskInfo as ti "
										+ "inner join ti.task as t "// on t.taskId = ti.taskId "
										+ "inner join ti.taskDetail as td "
										+ "where ti.taskId = t.taskId "
										+ "and ti.taskId = td.taskId and ti.taskDetailId = td.taskDetailId "
										+ "and ti.ssoId = \'" + userName + "\' "
										//+ "where ti.taskId = t.taskId and t.taskId=td.taskId "
										+ "order by ti.taskInfoId");// on td.taskId = ti.taskId ");
		String str = q.getQueryString();
		List<Object[]> taskInfoJoined = q.list();
		
//		List<Object[]> taskInfoJoined = session.createCriteria(Task.class, "t")
//			    .createAlias("t.taskInfos", "ti")
//			    .add( Restrictions.eqProperty("t.taskId", "ti.taskId") )
//			    //.createAlias("ti.TaskDetail", "td").add(Restrictions.eqProperty("td.taskId", "ti.taskId")).add(Restrictions.eqProperty("td.taskDetailId", "ti.taskDetailId"))
//			    //.addOrder(Order.asc("ti.taskId"))
//			    .list();
		
//		Criteria tiCriteria = session.createCriteria(TaskDetail.class,"td")
//				.createCriteria("Task", "t")
//				.createCriteria("t.TaskInfo", "ti");
		
//		Criteria tiCriteria = session.createCriteria(TaskInfo.class,"ti")
//				.createAlias("Task", "t")
//				.createAlias("t.TaskDetail", "td");
		
//				.createCriteria("Task", "t")
//				.createCriteria("TaskDetail", "td");
//		Criteria tCriteria =  tiCriteria.createCriteria("Task","t");
//		Criteria tdCriteria =  tCriteria.createCriteria("TaskDetail","td");
//		tdCriteria.add(Restrictions.eqProperty("ti.taskId", "t.taskId"));
//		tdCriteria.add(Restrictions.eqProperty("ti.taskId", "td.taskId"));

//		ProjectionList properties = Projections.projectionList();
//		properties.add(Projections.property("name"));
//		properties.add(Projections.property("id"));
//
//		accountCriteria.setProjection(properties);
//		List<Object[]> taskInfoJoined = tiCriteria.list();

//		Criteria crt2 = session.createCriteria(TaskInfo.class, "taskInfo");
//		crt2.setFetchMode("Task", "task", FetchMode.JOIN);
//		crt2.setFetchMode("TaskDetail", FetchMode.JOIN);
//		List<Object[]> taskInfoJoined = (List<Object[]>) crt2.list();
		
		return taskInfoJoined;
	}
	


}
