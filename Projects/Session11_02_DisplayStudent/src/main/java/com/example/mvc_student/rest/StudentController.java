package com.example.mvc_student.rest;

import com.example.mvc_student.entity.Student;
import com.example.mvc_student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public String listAllStudent(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students/students";
        // return link to HTML file but we don't need to type ".html" in html file name
    }
}
