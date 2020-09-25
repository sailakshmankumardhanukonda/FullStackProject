package com.infy.employeemanagementapplication.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
public class Swaggerconfig {
	
	
	@Bean
	public Docket swaggerConfiguration() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/employeemanagement/employee/**"))
				.apis(RequestHandlerSelectors.basePackage("com.infy"))
				.build()
				.apiInfo(new ApiInfo("Employee Management Details","this api has rest endpoints"
						+ " to create new employee,delete employee,update employee and get employee details"
						+ " of all employees and also individual employee",
						"1.1.0" ,"http://example.com",
						new Contact("sai","sai,dhanukonda@infosys.com","http://example.com"),
						"api liscence","http://example.com",Collections.emptyList()));
	
	
	
	}
	
	
	
	

}
