package com.profesorp.countriesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ContriesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContriesServiceApplication.class, args);
	}
	
}
