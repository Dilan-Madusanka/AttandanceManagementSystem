package com.attandance.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long employId;
	
	@Column(name="name")
	private String employName;
	
	@Column(name="age")
	private String employeeAge;
	
	@Column(name="department_id")
	private Long departmentId;
	
	@Column(name="dob")
	private Date Empdob;
	
	@Column(name="address")
	private String address;
	
	public Long getEmployId() {
		return employId;
	}
	public void setEmployId(Long employId) {
		this.employId = employId;
	}
	public String getEmployName() {
		return employName;
	}
	public void setEmployName(String employName) {
		this.employName = employName;
	}
	public String getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(String employeeAge) {
		this.employeeAge = employeeAge;
	}
	public Long getDepartment() {
		return departmentId;
	}
	public void setDepartment(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	public Date getEmpdob() {
		return Empdob;
	}
	public void setEmpdob(Date empdob) {
		Empdob = empdob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
