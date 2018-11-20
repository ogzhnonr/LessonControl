package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.TaskMilestoneDegree;

public interface TaskMilestoneDegreeService {
	
	TaskMilestoneDegree findBySsoId(int ssoId);
	
	TaskMilestoneDegree findByDenemeId(int denemeId);
	
	void save(TaskMilestoneDegree taskMilestoneDegree);
	
	void deleteBySsoId(int ssoId);
	
	void deleteByDenemeId(int denemeId);
	
	List<TaskMilestoneDegree> findAllTaskMilestoneDegreesBySsoId();
	
	List<TaskMilestoneDegree> findAllTaskMilestoneDegreesByDenemeId();


}
