package com.titv.session5_3constructorinjection.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.titv.session5_3constructorinjection.application",
                "com.titv.session5_3constructorinjection.rest",
                "com.titv.session5_3constructorinjection.service"
        }
)
public class Session5_4Qualifier_Autowired {

    public static void main(String[] args) {
        SpringApplication.run(Session5_4Qualifier_Autowired.class, args);
    }

}
