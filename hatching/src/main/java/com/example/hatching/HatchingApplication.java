package com.example.hatching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HatchingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HatchingApplication.class, args);
	}
}
