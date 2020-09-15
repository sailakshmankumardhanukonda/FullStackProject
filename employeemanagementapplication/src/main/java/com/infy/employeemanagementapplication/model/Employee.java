package com.infy.employeemanagementapplication.model;

import java.time.LocalDate;


import com.infy.employeemanagementapplication.entity.EmployeeEntity;

public class Employee {
	
	private int empId;
	private String firstName;
	private String middleName;
	private String lastName;
	private LocalDate dob;
	private String city;



      
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getMiddleName() {
		return middleName;
	}




	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public LocalDate getDob() {
		return dob;
	}




	public void setDob(LocalDate dob) {
		this.dob = dob;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public static EmployeeEntity getEntity(Employee employee) {
		
		EmployeeEntity emp=new EmployeeEntity();
		emp.setEmpId(employee.getEmpId());
		emp.setFirstName(employee.getFirstName());
		emp.setMiddleName(employee.getMiddleName());
		emp.setLastName(employee.getLastName());
		emp.setDob(employee.getDob());
		emp.setCity(employee.getCity());
		
		return emp;
		
		
		
		
		
	}
	
	

}
