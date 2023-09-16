package com.example.demo;

import com.example.demo.service.CalculatorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopAdviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopAdviceApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(CalculatorService calculator) {
        return runner -> {
//            double add = );
            calculator.add(5, 10);
            System.out.println("________");
            calculator.divide(5, 0);
        };
    }
}
