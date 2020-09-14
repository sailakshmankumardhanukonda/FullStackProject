package com.infy.employeemanagementapplication.model;

import java.util.Date;

import com.infy.employeemanagementapplication.entity.EmployeeEntity;

public class Employee {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dob;
	private String city;

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
   
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
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
		emp.setFirstName(employee.getFirstName());
		emp.setMiddleName(employee.getMiddleName());
		emp.setLastName(employee.getLastName());
		emp.setDob(employee.getDob());
		emp.setCity(employee.getCity());
		
		return emp;
		
		
		
		
		
	}
	
	

}
