package com.guru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.guru.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(method = RequestMethod.GET, value = "/name")
	private Employee[] getEmployeeList(){
		
	ResponseEntity responseEntity = restTemplate.exchange("http://spring-employee-microservice/employee/list",HttpMethod.GET,null,Employee[].class);
	
	Employee[] employees = (Employee[]) responseEntity.getBody();
	
	return employees;
	}
}
