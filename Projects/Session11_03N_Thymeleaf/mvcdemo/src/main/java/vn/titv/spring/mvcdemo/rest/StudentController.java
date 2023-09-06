package vn.titv.spring.mvcdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.titv.spring.mvcdemo.entity.Student;
import vn.titv.spring.mvcdemo.service.StudentService;
import vn.titv.spring.mvcdemo.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students2")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public String listAll(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/students";
    }
    /*  *Note*__ Method "Model.addAttribute" transmits the "student" Object líst to
    *   Thymeleaf .html file then we can use "th:each" to loop through this List
    *   and print all the information we want
    * */

    @GetMapping("/create")
    public String create(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "/student/students-form";
    }
    /*  *Note*__ Model find ".html" file through String which returned, it starts
    *   from directory "resources/ templates" then use relative path to find
    *   targeted file
    * */

    @PostMapping("/save")
    public String save(@ModelAttribute("student")Student student){
        studentService.addStudent(student);
        return "redirect:/students2/list";
    }
    /*  *Note*__When we use "redirect:", we return endpoint from "@RequestMapping()"
    * and concatenate with "@GetMapping()"
    *   __ @ModelAttribute("student") receive Object which is created in POST
    * form and convert it to your object Type you want
    * */
}
