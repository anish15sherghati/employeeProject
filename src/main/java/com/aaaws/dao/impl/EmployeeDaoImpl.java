package com.aaaws.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaaws.dao.IEmployeeDao;
import com.aaaws.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveEmployee(Employee e) {
		Integer i=(Integer)ht.save(e);
		
		return i;
	}
	@Override
	public List<Employee> getAllEmployee() {
		return ht.loadAll(Employee.class);
	}
	
	@Override
	public void deleteEmployeeById(Integer id) {
	ht.delete(new Employee(id));
	}
	
	
}
