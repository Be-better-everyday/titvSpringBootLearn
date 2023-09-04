package com.titv.session5_3constructorinjection.service;

import org.springframework.stereotype.Component;

@Component
public class ZaloService implements MessageService{

    public ZaloService() {
        System.out.println("Constructor of class :" + getClass().getSimpleName());
    }
    @Override
    public String sendMessage() {
        return "Zalo Message is sending...";
    }
}
