package com.example.p1_student.dao;

import com.example.p1_student.entity.Student;

import java.util.List;

public interface StudentDao {
    public List<Student> getAllstudent();
    public Student getStudentById(int id);
    public Student saveStudent(Student student);
    public Student saveAndFlushStudent(Student student);
    public Student deleteStudentById(int id);
    public List<Student> deleteStudentByFirstName(String firstName);
}
