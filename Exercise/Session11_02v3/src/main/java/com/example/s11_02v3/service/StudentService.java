package com.example.s11_02v3.service;

import com.example.s11_02v3.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public List<Student> getAll();
    public Optional<Student> getStudentById(Integer id);
    public Student saveStudent(Student s);
    public Student updateStudent(Student s);
    public Student deleteStudentById(Integer id);
}
