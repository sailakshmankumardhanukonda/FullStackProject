package com.infy.employeemanagementapplication.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.employeemanagementapplication.entity.EmployeeCourseEntity;
import com.infy.employeemanagementapplication.model.EmployeeCourse;
import com.infy.employeemanagementapplication.repository.EmployeeCourseRepository;


@Service
public class EmployeeCourseServiceImpl {
	
	
	@Autowired
	private EmployeeCourseRepository employeeCourseRepository;
	
	public List<EmployeeCourse> getAllCourses(){
		
		List<EmployeeCourse> emplist2=new ArrayList<>();
		
		Iterable<EmployeeCourseEntity> emplist3=employeeCourseRepository.findAll();
		
		emplist3.forEach(course -> emplist2.add(EmployeeCourseEntity.getModel(course)));

		return emplist2;
		
	}
	
	
	public EmployeeCourse getCourseName(int courseId) {
		
		String message;
		
		EmployeeCourse emp1=new EmployeeCourse();
		
		boolean isPresent=employeeCourseRepository.findById(courseId).isPresent();
		
		if(!isPresent)
			message="EmployeeCourseService.COURSE_DOES_NOT_EXISTS";
		
		else {
			
			EmployeeCourseEntity emp=employeeCourseRepository.findById(courseId).get();
			emp1.setCourseId(emp.getCourseId());
			emp1.setCourseName(emp.getCourseName());
		}
		
		
		
		return emp1;
	}
	
	
	
	public String updateOrCreateCourse(int courseId,String courseName) {
		
		String message;
		
		boolean isPresent=employeeCourseRepository.findById(courseId).isPresent();
		
		if(isPresent) {
			EmployeeCourseEntity emp=employeeCourseRepository.findById(courseId).get();
			
			emp.setCourseName(courseName);
			message="EmployeeCourseRepository.COURSE_NAME_UPDATED";
			employeeCourseRepository.save(emp);
		}else {
			
			EmployeeCourseEntity emp=new EmployeeCourseEntity();
			emp.setCourseId(courseId);
			emp.setCourseName(courseName);
			message="EmployeeCourseRepository.COURSE_CREATED";
			employeeCourseRepository.save(emp);
		}
		
		return message;
		
		
	}
	
	
	public String deleteCourse(int CourseId) {
		
		String message;
		
		boolean isPresent=employeeCourseRepository.findById(CourseId).isPresent();
		
		if(!isPresent) {
			message="EmployeeCourseService.COURSE_DOES_NOT_EXISTS";
		}else {
			employeeCourseRepository.deleteById(CourseId);
			message="EmployeeCourseRepository.COURSE_DELETED_SUCESSFULLY";
		}
		
		return message;
	}
	
	
	
	

}
