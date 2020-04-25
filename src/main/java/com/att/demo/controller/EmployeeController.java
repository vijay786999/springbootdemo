package com.att.demo.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.att.demo.dao.EmployeeDAO;
import com.att.demo.model.Employee;
import com.att.demo.model.Employees;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeDAO employeeDao;
	
	@GetMapping(path = "/employees", produces = "application/json")
	public Employees getEmployees() {
		return employeeDao.getAllEmployees();
	}
	
	@PostMapping(path="/employees", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {
		
		Integer id = employeeDao.getAllEmployees().getEmployees().size()+1;
		employee.setId(id);
		
		employeeDao.addEmployee(employee);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(employee.getId()).toUri();
				
		
		return ResponseEntity.created(location).build();
		
	}
	
	@DeleteMapping(path = "/employees/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		
		employeeDao.deleteEmployee(id);
		/*
		List<Employee> empList = new ArrayList<>();
		empList = employeeDao.getAllEmployees().getEmployees();
		
		Iterator itr = empList.iterator();
		
		while(itr.hasNext()) {
			if()
		}*/
	}
}
