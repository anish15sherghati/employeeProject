package com.aaaws.dao;

import java.util.List;

import com.aaaws.model.Employee;

public interface IEmployeeDao {
	
	Integer saveEmployee(Employee e);
	
	List<Employee> getAllEmployee();

	void deleteEmployeeById(Integer id);
	
}
