package com.infy.employeemanagementapplication.service;


import java.util.List;
import java.util.Map;

import com.infy.employeemanagementapplication.model.Employee;

public interface EmployeeService {

	public String createEmployee(Employee employee);
	
	public Map<Integer, Employee> getEmployee(int empId);
	
	public Map<Integer, Employee> getAll();
	
	public String updateEmployee(Employee employee);
	
	public String deleteEmployee(int empId);
	
	public List<Employee> getByEmployeeFirstName(String name);
	
}
