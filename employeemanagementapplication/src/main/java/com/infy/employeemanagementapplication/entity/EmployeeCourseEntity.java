package com.infy.employeemanagementapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.employeemanagementapplication.model.EmployeeCourse;

@Entity
@Table(name="employeecourse")
public class EmployeeCourseEntity {
	
	@Id
	@Column(name="courseid")
	private int courseId;
	
	@Column(name="coursename")
	private String courseName;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	public static EmployeeCourse getModel(EmployeeCourseEntity employee) {
		
		EmployeeCourse emp=new EmployeeCourse();
		emp.setCourseId(employee.getCourseId());
		emp.setCourseName(employee.getCourseName());
		
		return emp;
		
	}
	

}
