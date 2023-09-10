package com.example.studentmanagement.dao;

import com.example.studentmanagement.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        String jpql = "select s from Student s";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public Student getById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
//    @Transactional  ==> Use @Transaction in StudentServiceImpl so we no longer need @Transaction in here
    public Student save(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
//    @Transactional  ==> Use @Transaction in StudentServiceImpl so we no longer need @Transaction in here
    public Student saveAndFlush(Student student) {
        student = entityManager.merge(student);
        entityManager.flush();
        /* flush() method force the database to synchronize with the changes that have been made */
        return  student;
    }

    @Override
//    @Transactional ==> Use @Transaction in StudentServiceImpl so we no longer need @Transaction in here
    public void deleteById(int id) {
        Student student = entityManager.find(Student.class, id);
        entityManager.remove(student);
    }
}
