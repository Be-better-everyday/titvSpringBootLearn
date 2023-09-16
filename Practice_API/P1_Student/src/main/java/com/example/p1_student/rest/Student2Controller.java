package com.example.p1_student.rest;

import com.example.p1_student.entity.Student2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student2")
public class Student2Controller {
    private Student2 student2;

    @Autowired
    public Student2Controller(@Qualifier("myStudent2")Student2 student2) {
        this.student2 = student2;
    }
}
