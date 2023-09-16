package com.example.p1_student.rest;

import com.example.p1_student.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students2")
public class StudentController2 {
    private Message message;

    @Autowired
    public StudentController2(Message message) {
        this.message = message;
    }

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return this.message.sendMessage();
    }
}
