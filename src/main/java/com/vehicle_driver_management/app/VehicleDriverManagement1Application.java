package com.vehicle_driver_management.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class VehicleDriverManagement1Application {

	public static void main(String[] args) {
		SpringApplication.run(VehicleDriverManagement1Application.class, args);
	}

}
