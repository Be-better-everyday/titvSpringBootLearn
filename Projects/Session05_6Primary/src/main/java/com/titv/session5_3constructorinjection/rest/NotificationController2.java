package com.titv.session5_3constructorinjection.rest;

import com.titv.session5_3constructorinjection.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController2 {
//    MessageService service;
    @GetMapping("/email")
    @Autowired
    public String sendEmail(@Qualifier("emailService")MessageService service){
        return service.sendMessage();
    }

//    @GetMapping("/sms")
//    @Autowired
//    public String sendSms(@Qualifier("smsService")MessageService service){
//        return service.sendMessage();
//    }
//
//    @GetMapping("/zalo")
//    @Autowired
//    public String sendZalo(@Qualifier("zaloService")MessageService service){
//        return service.sendMessage();
//    }
}
