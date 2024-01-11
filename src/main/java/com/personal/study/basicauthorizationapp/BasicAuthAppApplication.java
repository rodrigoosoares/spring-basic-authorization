package com.personal.study.basicauthorizationapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BasicAuthAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(BasicAuthAppApplication.class, args);
	}

}
