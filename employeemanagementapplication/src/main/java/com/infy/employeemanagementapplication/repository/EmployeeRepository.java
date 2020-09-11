package com.infy.employeemanagementapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.infy.employeemanagementapplication.entity.EmployeeEntity;



@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

}