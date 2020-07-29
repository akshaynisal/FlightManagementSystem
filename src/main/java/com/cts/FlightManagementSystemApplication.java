package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories()
public class FlightManagementSystemApplication {

public static void main(String[] args) {
		SpringApplication.run(FlightManagementSystemApplication.class, args);
		}

		}
