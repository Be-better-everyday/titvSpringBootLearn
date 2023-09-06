package vn.titv.spring.demo.service;

import vn.titv.spring.demo.entity.Student;
import vn.titv.spring.demo.rest.StudentController;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public Student getStudentById(int id);

    public Student addStudent(Student student);

    public Student updateStudent(Student student);

    public void deleteStudentById(int id);

}
