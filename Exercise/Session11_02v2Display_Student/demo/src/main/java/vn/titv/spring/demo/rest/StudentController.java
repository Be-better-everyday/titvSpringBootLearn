package vn.titv.spring.demo.rest;


import org.aspectj.lang.annotation.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.titv.spring.demo.entity.Student;
import vn.titv.spring.demo.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/api/students")
public class StudentController {
    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public String getAllStudent(Model model){
        List<Student> students = studentService.getAllStudents();
        System.out.println("Students: ");
        System.out.println(students);
        model.addAttribute("students", students);
        return "studentList";
    }

    @GetMapping("/create")
    public String create(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "studentForm";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("student") Student student){
        studentService.addStudent(student);
        return "redirect:/api/students";
    }

    @GetMapping("/update")
    public String update(Model model, @RequestParam("id") int id){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "studentForm";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id){
        studentService.deleteStudentById(id);
        return "redirect:/api/students";
    }


}
