package com.example.p1_student.configBean;

import com.example.p1_student.entity.Student2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    @Bean
    public Student2 myStudent2(){
        System.out.println("Config to create Student2 Object");
        return new Student2();
    }
}
