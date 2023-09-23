package com.example.s11_02v3.controller;

import com.example.s11_02v3.converter.GenderConverter;
import com.example.s11_02v3.entity.Gender;
import com.example.s11_02v3.entity.Student;
import com.example.s11_02v3.service.StudentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public String getAllStudent(Model model){
        List<Student> studentList = studentService.getAll();
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student student, Student t1) {
                return student.getId().compareTo(t1.getId());
            }
        });
        model.addAttribute("students", studentList);
        return "student";
    }

    @GetMapping("/student-form")
    public String goToStudentForm(Model model){
        Student student = new Student();
        String genderStr = "";
        model.addAttribute("student", student);
        return "studentForm";
    }

    @PostMapping("/add")
    public String addNewStudent(@ModelAttribute("student")Student student
    ){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/update")
    public String updateStudent(
            Model model, @RequestParam int id
    ){
        Optional<Student> student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "studentForm";
    }

    @GetMapping("/delete")
    public String deleteStudent(
            @RequestParam int id
    ){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "login";
    }

    @GetMapping("/page403")
    public String page403(){
        return "page403";
    }

    @RequestMapping("/login-success")
    public String loginSuccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            // Use SavedRequestAwareAuthenticationSuccessHandler to redirect to the original URL
            SimpleUrlAuthenticationSuccessHandler handler =
                    new SimpleUrlAuthenticationSuccessHandler ();
            handler.setDefaultTargetUrl("/");
            handler.setUseReferer(true);
            handler.onAuthenticationSuccess(request, response, auth);
        }
        return "redirect:/";
    }

    @GetMapping("/index")
    public String goToIndex(){
        return "index";
    }
}
