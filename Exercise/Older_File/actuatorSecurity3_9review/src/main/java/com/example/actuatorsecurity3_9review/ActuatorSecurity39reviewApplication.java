package com.example.actuatorsecurity3_9review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ActuatorSecurity39reviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActuatorSecurity39reviewApplication.class, args);
    }

    @GetMapping("/")
    public String index(){
        return "Hello 123 !";
    }
}
