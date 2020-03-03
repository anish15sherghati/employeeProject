package com.aaaws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeetab")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="eid")
	private Integer empId;
	@Column(name="ename",length = 25)
	private String empName;
	@Column(name="esal")
	private Double empSal;
	
	public Employee() {
		super();
	}

	public Employee(Integer empId) {
		super();
		this.empId=empId;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}
	
	
}
