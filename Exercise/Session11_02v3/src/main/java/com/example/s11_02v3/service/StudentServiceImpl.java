package com.example.s11_02v3.service;

import com.example.s11_02v3.dao.StudentRepository;
import com.example.s11_02v3.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    @Transactional
    public Student saveStudent(Student s) {
        return studentRepository.save(s);
    }

    @Override
    @Transactional
    public Student updateStudent(Student s) {
        return studentRepository.saveAndFlush(s);
    }

    @Override
    @Transactional
    public Student deleteStudentById(Integer id) {
        Student student = studentRepository.getById(id);
        studentRepository.deleteById(id);
        return student;
    }
}
