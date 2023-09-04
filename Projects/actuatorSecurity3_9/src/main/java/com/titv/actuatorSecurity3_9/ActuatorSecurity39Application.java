package com.titv.actuatorSecurity3_9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ActuatorSecurity39Application {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorSecurity39Application.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "Xin chao 123!sdf";
	}
}
