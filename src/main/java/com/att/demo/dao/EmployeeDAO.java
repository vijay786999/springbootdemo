package com.att.demo.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.att.demo.model.Employee;
import com.att.demo.model.Employees;

@Repository
public class EmployeeDAO {
	
	private static Employees list = new Employees();
	
	static {
		list.getEmployees().add(new Employee(1, "Badari", "Jallipalli", "badari@gmail.com"));
		list.getEmployees().add(new Employee(2, "Praveen", "Devineni", "praveen@gmail.com"));
		list.getEmployees().add(new Employee(3, "Satakarni", "Makkampati", "sata@gmail.com"));
	}
	
	public Employees getAllEmployees(){
		return  list;
		
	}
	
	public void addEmployee(Employee employee) {
		list.getEmployees().add(employee);
	}
	
	public void deleteEmployee(Integer id) {
		List<Employee> empList = new ArrayList<>();
		empList = list.getEmployees();
		
		Iterator itr = empList.iterator();
		while(itr.hasNext()) {
			Employee employee = (Employee) itr.next();
			if(employee.getId().equals(id)) {
				itr.remove();
			}
			
		}
		/*
		for(Employee employee:list.getEmployees()) {	
			if(employee.getId().equals(id)) {
				
			}
		}*/
	}

}
