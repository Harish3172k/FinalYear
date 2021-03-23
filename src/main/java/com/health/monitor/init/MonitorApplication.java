package com.health.monitor.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.health.monitor.controller.RestApiController;


@SpringBootApplication
@ComponentScan(basePackageClasses = RestApiController.class)
public class MonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorApplication.class, args);
	}

}
