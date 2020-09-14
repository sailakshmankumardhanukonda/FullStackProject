package com.infy.employeemanagementapplication.service;


import java.util.Map;

import com.infy.employeemanagementapplication.model.Employee;

public interface EmployeeService {

	public String createEmployee(Employee employee);
	
	public Map<Integer, Employee> getEmployee(int empId);
	
	public Map<Integer, Employee> getAll();
	
	public String updateEmployeeCity(int empId,String city);
	
	public String deleteEmployee(int empId);
	
}
