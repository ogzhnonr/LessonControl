package com.websystique.springmvc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TASKMILESTONEDEGREE")
public class TaskMilestoneDegree implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name="SSOID", nullable=false)
	private String ssoId;
	
	@NotNull
	@Column(name="DENEMEID", nullable=false)
	private Integer denemeId;

	@NotNull
	@Column(name="TASKMILESTONEGENERALDEGREE", nullable=false)
	private Integer taskMilestoneGeneralDegree;
	
	@NotNull
	@Column(name="TASKMILESTONEGENERALPERCENTAGE", nullable=false)
	private Double taskMilestoneGeneralPercentage;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSsoId() {
		return ssoId;
	}

	public void setSsoId(String ssoId) {
		this.ssoId = ssoId;
	}

	public Integer getDenemeId() {
		return denemeId;
	}

	public void setDenemeId(Integer denemeId) {
		this.denemeId = denemeId;
	}

	public Integer getTaskMilestoneGeneralDegree() {
		return taskMilestoneGeneralDegree;
	}

	public void setTaskMilestoneGeneralDegree(Integer taskMilestoneGeneralDegree) {
		this.taskMilestoneGeneralDegree = taskMilestoneGeneralDegree;
	}

	public Double getTaskMilestoneGeneralPercentage() {
		return taskMilestoneGeneralPercentage;
	}

	public void setTaskMilestoneGeneralPercentage(Double taskMilestoneGeneralPercentage) {
		this.taskMilestoneGeneralPercentage = taskMilestoneGeneralPercentage;
	}
	
}
