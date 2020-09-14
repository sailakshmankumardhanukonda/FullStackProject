package com.infy.employeemanagementapplication.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employeemanagementapplication.model.EmployeeCourse;
import com.infy.employeemanagementapplication.service.EmployeeCourseServiceImpl;

@CrossOrigin
@RestController
public class EmployeeCourseAPI {

	@Autowired
	private EmployeeCourseServiceImpl employeeCourseServiceImpl;
	
	@GetMapping(value="/getallcourses")
	public List<EmployeeCourse> getAllCourses(){
		
		return employeeCourseServiceImpl.getAllCourses();
		
		
	}
	
	@GetMapping(value="/getcourse/{courseid}")
	public EmployeeCourse getCourseName(@PathVariable int courseid) {
		
		return employeeCourseServiceImpl.getCourseName(courseid);
		
		
	}
	
	
	@PutMapping(value="/updateorcreate/{courseid}/{coursename}")
	public String updateOrCreateCourse(@PathVariable int courseid,@PathVariable String coursename) {
		
		return employeeCourseServiceImpl.updateOrCreateCourse(courseid, coursename);
		
	}
	
	@DeleteMapping(value="/deletecourse/{courseid}")
	public String deleteCourse(@PathVariable int courseid) {
		
		
		return employeeCourseServiceImpl.deleteCourse(courseid);
		
		
		
	}
	
	
	
	
	
	
	
}
