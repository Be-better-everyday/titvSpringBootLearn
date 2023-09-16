package com.titv.session5_3constructorinjection.rest;

import com.titv.session5_3constructorinjection.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.titv.session5_3constructorinjection.service.MessageService;

@RestController
public class NotificationController {

    private MessageService service1;
    private MessageService service2;
    @Autowired
    public NotificationController(
            @Qualifier("emailService")MessageService service1,
            @Qualifier("emailService")MessageService service2
    ) {
        this.service1 = service1;
        this.service2 = service2;
    }

    @GetMapping("/send-email")
    public String sendEmail(){
        return this.service1.sendMessage();
    }

    @GetMapping("/check")
    public String check(){
        return "Check: " + (service1 == service2);
    }

    @GetMapping("/check2")
    public String check2(){
        if(service1 == service2){
            return "SINGLETON";
        }else return "PROTOTYPE";
    }
}
