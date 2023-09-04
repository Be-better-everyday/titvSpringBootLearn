package com.titv.session5_3constructorinjection.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SmsService implements MessageService{
    @Override
    public String sendMessage() {
        return "Sending SmsMessage...";
    }
}
