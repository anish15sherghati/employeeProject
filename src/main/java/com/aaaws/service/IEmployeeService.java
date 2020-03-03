package com.aaaws.service;

import java.util.List;

import com.aaaws.model.Employee;

public interface IEmployeeService {

	Integer saveEmployee(Employee e);
	
	List<Employee> getAllEmployee();
	
	void deleteEmployeeById(Integer id);
}
