package com.example.studentmanagement.dao;

import com.example.studentmanagement.entity.Student;

import java.util.List;

public interface StudentDAO
{
    public List<Student> findAll();
    public Student getById(int id);
    public Student save(Student student);
    //Update
    public Student saveAndFlush(Student student);
    public void deleteById(int id);
}
