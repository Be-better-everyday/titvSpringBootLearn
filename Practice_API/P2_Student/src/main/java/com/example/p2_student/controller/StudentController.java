package com.example.p2_student.controller;

import com.example.p2_student.entity.Student2;
import com.example.p2_student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    StudentRepository repository;

    @Autowired
    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public String home(){
        return "hello !";
    }

    @GetMapping("/first-name/{firstName}")
    public List<Student2> getListStudentHavingFirstName(@PathVariable("firstName") String firstName){
        return repository.findByFirstName(firstName);
//        return firstName;
    }

    @GetMapping("/id_firstName/{firstName}/{id}")
    public List<Student2> getListStudentHavingFirstName(
            @PathVariable("firstName") String firstName,
            @PathVariable("id") int id){
        if(id == 0) id = 100;
        System.out.println(id + "___" + firstName);
        return repository.findByFirstNameContainingAndIdLessThan(firstName, id);
//        return firstName;
    }
}
