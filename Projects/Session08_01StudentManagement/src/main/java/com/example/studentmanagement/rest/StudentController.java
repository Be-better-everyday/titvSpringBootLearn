package com.example.studentmanagement.rest;

import com.example.studentmanagement.dao.StudentDAO;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> getAllStudent(){
        return this.studentService.getAllStudents();
    }

    @GetMapping("/{id}")        /* this endpoint can throw exception */
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        Student student = studentService.getStudentById(id);
        if(student != null){
            return ResponseEntity.ok(student);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    /*  @RequestBody help convert JSON,which is posted, to "student" Object*/
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        student.setId(0);
        /* When you set Id = 0,
        Database will understand you want they want to create new Id */

        student = studentService.addStudent(student);
        /*
        *   Create ResponseEntity with Http Status (Object have been created)
        *   It hasn't handled error ==> need handle in the future
        * */
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{id}")
    /*  @RequestBody help convert JSON,which is posted, to "student" Object*/
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
        Student existingStudent = studentService.getStudentById(id);

        if(existingStudent != null){
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setEmail(student.getEmail());
            studentService.updateStudent(existingStudent);
            return ResponseEntity.ok(existingStudent);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id){
        Student existingStudent = studentService.getStudentById(id);

        if(existingStudent != null){
            studentService.deleteStudentById(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
