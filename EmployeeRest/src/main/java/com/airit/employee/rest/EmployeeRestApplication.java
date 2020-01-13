package com.airit.employee.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
public class EmployeeRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestApplication.class, args);
	}
}
