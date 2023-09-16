package com.example.p1_student.rest;

import com.example.p1_student.dao.StudentDao;
import com.example.p1_student.entity.Message;
import com.example.p1_student.entity.Student;
import com.example.p1_student.entity.ZaloMessage;
import com.example.p1_student.exception.HandmadeException;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private Message message;
    private StudentDao studentDao;

    @Autowired
    public StudentController( Message message, StudentDao studentDao) {
//        @Qualifier("zaloMessage")
        this.message = message;
        this.studentDao = studentDao;
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentDao.getAllstudent();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        return ResponseEntity.ok(studentDao.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        student.setId(null);
        student = studentDao.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable int id, @RequestBody Student student){
        Student updatedStudent = studentDao.getStudentById(id);
        if(updatedStudent == null){
            return ResponseEntity.notFound().build();
        }else {
            student.setId(updatedStudent.getId());
            return ResponseEntity.ok(studentDao.saveAndFlushStudent(student));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id){
        Student student = studentDao.deleteStudentById(id);
        if(student == null){
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(student);
        }
    }

    @DeleteMapping("/deleteByName/{firstName}")
    public ResponseEntity<List<Student>> deleteStudentByName(@PathVariable String firstName){
        List<Student> result = studentDao.deleteStudentByFirstName(firstName);
        if(result.size() == 0) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return this.message.sendMessage();
    }

    @GetMapping("/ex")
    public ResponseEntity<Student> throwException(){
        throw new HandmadeException("Custom Ex", "3307");
    }

    @ExceptionHandler(HandmadeException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String ToDoException(Exception ex){
        return ex.getMessage();
    }
}
