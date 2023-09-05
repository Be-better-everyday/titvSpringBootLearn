package com.example.studentmanagement.service;


import com.example.studentmanagement.dao.StudentRepo;
import com.example.studentmanagement.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // là Component sẽ được tự tạo ra và inject vào vị trí thích hợp
public class StudentServiceImpl implements StudentService{
    /*
    * In this exercise, there is only 1 DAO but in other project, it may be having a lot of DAO
    * */
    private StudentRepo studentRepo;
    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getAllStudentNotFirstName(String name) {
        return studentRepo.findByFirstNameNot(name);
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
