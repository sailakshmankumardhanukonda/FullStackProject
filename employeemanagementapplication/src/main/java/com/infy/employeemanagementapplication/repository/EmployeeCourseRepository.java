package com.infy.employeemanagementapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.infy.employeemanagementapplication.entity.EmployeeCourseEntity;

@Repository
public interface EmployeeCourseRepository extends CrudRepository<EmployeeCourseEntity, Integer> {

}
