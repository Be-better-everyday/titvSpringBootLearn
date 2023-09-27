package com.example.onetoone_uni.dao;

import com.example.onetoone_uni.entity.Student;

public interface StudentDao {
    public void save(Student student);
    public Student findStudentById(int id);
    public void updateStudent(Student student);
}
