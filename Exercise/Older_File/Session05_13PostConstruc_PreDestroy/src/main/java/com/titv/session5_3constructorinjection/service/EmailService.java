package com.titv.session5_3constructorinjection.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmailService implements MessageService{

    @PostConstruct
    public void init(){
        System.out.println("@PostConstruct is created right after Constructor " + getClass().getSimpleName());
    }

    @PreDestroy
    public void myDestroy(){
        System.out.println("@PreDestroy runs before destroy Bean " + getClass().getSimpleName());
    }

    public EmailService() {
        System.out.println("Constructor of class :" + getClass().getSimpleName());
    }
    @Override
    public String sendMessage() {
        return "Email sending .....12";
    }
}
