package com.example.studentmanagement.service;

import com.example.studentmanagement.dao.StudentDAO;
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
    private StudentDAO studentDAO;
    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDAO.getById(id);
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return studentDAO.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentDAO.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        studentDAO.deleteById(id);
    }
}
