package com.titv.session5_3constructorinjection.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component

public class EmailService implements MessageService{

    @Override
    public String sendMessage() {
        return "Email sending .....12";
    }
}
