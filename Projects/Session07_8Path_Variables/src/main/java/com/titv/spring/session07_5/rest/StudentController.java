package com.titv.spring.session07_5.rest;

import com.titv.spring.session07_5.entity.ErrorResponse;
import com.titv.spring.session07_5.entity.Student;
import com.titv.spring.session07_5.exception.StudentException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    public List<Student> students;

    @PostConstruct
    public void createStudents(){
        students = new ArrayList<Student>();
        students.add(new Student(1, "Nguyen Van A", 18, "CNTT", 9));
        students.add(new Student(2, "Le Van B", 22, "KT", 8.7));
        students.add(new Student(3, "Nguyen Thi C", 21, "KTDN", 8.6));
        students.add(new Student(4, "La van D", 20, "CN", 7));
        students.add(new Student(5, "Nguyen Van E", 19, "KTTT", 9.1));
    }

    /*   Link endpoint ==> http://localhost:8080/students/    */
    /*  Spring đã tự động convert Object to JSON
    ==> Nếu không dùng Spring thì phải tìm cách dựa trên Framework đó
    ==> Convert List thành mảng JSON, thông qua getter,setter để tạo JSON
    */
    @GetMapping("/")
    public List<Student> getStudents(){
        return students;
    }

    /* ____________ 7.8 Path Variables _____________*/
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        Student student = students.stream().filter(s-> s.getId() == id).findFirst().orElse(null);
        if(student == null) throw new StudentException("Student not found with id = " + id);
        return student;
    }

    @GetMapping("/index/{index}")
    public Student getStudent2(@PathVariable int index){
        try {
            return students.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new StudentException("Student not found with index = " + index);
        }
    }
    /*______________ 7.9 _________________*/

    @ExceptionHandler // this method catch StudentException
    public ResponseEntity<ErrorResponse> catchError(StudentException ex){
        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler   // This method catch all Exception ==> Not really recommended!
    public ResponseEntity<ErrorResponse> catchError1(Exception ex){
        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }
}
