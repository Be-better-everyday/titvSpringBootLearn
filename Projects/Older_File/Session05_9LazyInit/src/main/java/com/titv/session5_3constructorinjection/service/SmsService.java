package com.titv.session5_3constructorinjection.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Lazy
public class SmsService implements MessageService{
    public SmsService() {
        System.out.println("Constructor of class :" + getClass().getSimpleName());
    }

    @Override
    public String sendMessage() {
        return "Sending SmsMessage...";
    }
}
