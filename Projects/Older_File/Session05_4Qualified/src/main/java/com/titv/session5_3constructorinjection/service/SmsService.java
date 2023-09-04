package com.titv.session5_3constructorinjection.service;

import org.springframework.stereotype.Component;

@Component
public class SmsService implements MessageService{
    @Override
    public String sendMessage() {
        return "Sending SmsMessage...";
    }
}
