package com.titv.session5_3constructorinjection;

import org.springframework.stereotype.Component;

@Component
public class EmailService implements MessageService{

    @Override
    public String sendMessage() {
        return "Email sending .....";
    }
}
