package com.titv.session5_3constructorinjection.rest;

import com.titv.session5_3constructorinjection.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.titv.session5_3constructorinjection.service.MessageService;

@RestController
public class NotificationController {

    private MessageService service;
    @Autowired
    public NotificationController(@Qualifier("emailService")MessageService service) {
        this.service = service;
    }

    @GetMapping("/send-email")
    public String sendEmail(){
        return this.service.sendMessage();
    }
}
