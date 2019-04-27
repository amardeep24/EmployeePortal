package com.amardeep.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@ComponentScan("com.amardeep")
@EntityScan(basePackages = {"com.amardeep.employee.entity"})
@EnableSpringDataWebSupport
@EnableJpaRepositories(basePackages = "com.amardeep.employee.repository")
public class EmployeePortalApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeePortalApplication.class, args);
	}

}
