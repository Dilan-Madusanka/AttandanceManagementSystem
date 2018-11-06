package com.attandance.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Attndance {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long attandanceId;
	
	@Column(name="empId")
	private Long employeeId;
	
	@Column(name="depId")
	private Long DepartmentId;
	
	@Column(name="createdDate")
	private Date createdDate;
	
	@Column(name="createdTime")
	private String createdTime;
	
	public Long getAttandanceId() {
		return attandanceId;
	}
	public void setAttandanceId(Long attandanceId) {
		this.attandanceId = attandanceId;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Long getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(Long departmentId) {
		DepartmentId = departmentId;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	
	
}
