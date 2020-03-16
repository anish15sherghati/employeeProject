package com.aaaws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.aaaws.model.Employee;
import com.aaaws.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@RequestMapping("/register")
	public String showEmpRegPage(Model model) {
		System.out.println("helloo");
		model.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveEmpRegister(@ModelAttribute Employee employee, Model model) {
		Integer i = service.saveEmployee(employee);
		String msg = "add " + i + " done";
		model.addAttribute("message", msg);
		return "EmployeeRegister";
	}

	@RequestMapping("/all")
	public String allEmployeeData(Model model) {
		List<Employee> list = service.getAllEmployee();
		model.addAttribute("employees", list);
		return "EmployeeData";
	}

	@RequestMapping("/delete")
	public String deleteSelectedIdData(@RequestParam("eid") Integer id, Model model) {
		service.deleteEmployeeById(id);
		String msg = "Record with '" + id + " 'Done Completed";
		model.addAttribute("message", msg);
		return "EmployeeData";
	}

}
