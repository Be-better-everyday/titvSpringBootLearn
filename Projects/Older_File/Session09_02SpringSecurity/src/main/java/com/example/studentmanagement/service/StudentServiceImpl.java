package com.example.studentmanagement.service;


import com.example.studentmanagement.dao.StudentRepo;
import com.example.studentmanagement.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override

    public Student getStudentById(int id) {
        return studentRepo.getById(id);
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentRepo.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        studentRepo.deleteById(id);
    }
}
