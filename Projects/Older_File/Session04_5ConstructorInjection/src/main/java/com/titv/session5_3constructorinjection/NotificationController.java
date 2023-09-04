package com.titv.session5_3constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    // Field Injection
    /*
    * Proplem: _ difficult reading
    *          _ difficult to unique test (because it was injected in default)
    * */
    @Autowired
    private MessageService email;

    @GetMapping("/send-email")
    public String sendEmail(){
        return this.email.sendMessage();
    }
}
