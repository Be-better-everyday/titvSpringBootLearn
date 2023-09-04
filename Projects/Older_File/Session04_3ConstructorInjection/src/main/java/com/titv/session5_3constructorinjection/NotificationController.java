package com.titv.session5_3constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private MessageService email;

    // Tập trung vào việc cần có constructor và nó tự động tiêm phụ thuộc vào
    // Khi sử dụng @Autowired thì sẽ tìm những class được gắn @Component để tự tạo đối tượng và inject vào Constructor
    @Autowired
    public NotificationController(MessageService email) {
        this.email = email;
    }

    @GetMapping("/send-email")
    public String sendEmail(){
        return this.email.sendMessage();
    }
}
