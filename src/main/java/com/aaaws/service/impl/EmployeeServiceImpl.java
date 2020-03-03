package com.aaaws.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaaws.dao.IEmployeeDao;
import com.aaaws.model.Employee;
import com.aaaws.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao dao;

	@Override
	@Transactional
	public Integer saveEmployee(Employee e) {
		
		return dao.saveEmployee(e);
	}
	@Override
	public List<Employee> getAllEmployee() {
		return dao.getAllEmployee();
	}
	@Override
	@Transactional
	public void deleteEmployeeById(Integer id) {
		dao.deleteEmployeeById(id);
		
	}

}
