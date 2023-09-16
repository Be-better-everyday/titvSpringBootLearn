package com.example.p1_student.dao;

import com.example.p1_student.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    EntityManager entityManager;

    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAllstudent() {
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student getStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public Student saveAndFlushStudent(Student student) {
        entityManager.merge(student);
        entityManager.flush();
        return student;
    }

    @Override
    @Transactional
    public Student deleteStudentById(int id) {
        Student student = getStudentById(id);
        if(student != null){
            entityManager.remove(student);
        }
        return student;
    }

    @Override
    @Transactional
    public List<Student> deleteStudentByFirstName(String firstName) {
        String jpql1 = "select s from Student s where s.firstName like '%'||:firstName||'%'";
        String jpql = "DELETE FROM Student s where s.firstName like '%'||:firstName||'%'";

        Query query1 = entityManager.createQuery(jpql1);
        Query query = entityManager.createQuery(jpql);

        query1.setParameter("firstName", firstName);
        query.setParameter("firstName", firstName);

        List<Student> deletedStudentList = query1.getResultList();
        query.executeUpdate();
        return deletedStudentList;
    }
}
