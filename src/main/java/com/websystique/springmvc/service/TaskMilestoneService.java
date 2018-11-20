package com.websystique.springmvc.service;

import java.util.List;


import com.websystique.springmvc.model.TaskMilestone;

public interface TaskMilestoneService {
	
	TaskMilestone findBySsoId(int ssoId);
	
	TaskMilestone findByDenemeId(int denemeId);
	
	void save(TaskMilestone taskMilestone);
	
	void deleteBySsoId(int ssoId);
	
	void deleteByDenemeId(String userName, int denemeId);
	
	TaskMilestone getLastTaskMilestoneBySsoId(String ssoId);
	
	List<TaskMilestone> findAllTaskmilestones(String ssoId);


}
