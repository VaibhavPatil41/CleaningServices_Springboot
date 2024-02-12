package com.cleaningServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cleaningServices.*")
public class SpringBootCleaningServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCleaningServicesApplication.class, args);
	}

}
