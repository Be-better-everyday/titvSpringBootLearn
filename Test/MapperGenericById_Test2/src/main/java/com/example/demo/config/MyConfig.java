package com.example.demo.config;

import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {
    @Bean
    public Hibernate6Module hibernateModule() {
        return new Hibernate6Module();
    }
}
