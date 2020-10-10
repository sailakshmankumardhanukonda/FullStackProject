package com.infy.employeemanagementapplication;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class EmployeemanagementapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagementapplicationApplication.class, args);
	}
	

}
