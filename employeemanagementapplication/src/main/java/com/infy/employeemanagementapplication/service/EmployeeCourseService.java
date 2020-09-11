package com.infy.employeemanagementapplication.service;

import java.util.List;

import com.infy.employeemanagementapplication.model.EmployeeCourse;

public interface EmployeeCourseService {

	public List<EmployeeCourse> getAllCourses();
	
	public EmployeeCourse getCourseName(int courseId);
	
	public String updateOrCreateCourse(int courseId,String courseName);
	
	public String deleteCourse(int CourseId);
	
}
