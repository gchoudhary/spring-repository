package com.guru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guru.model.Employee;
import com.guru.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService EmployeeService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public @ResponseBody List<Employee> getAllEmployees() {

		return EmployeeService.findAll();
	}
}
