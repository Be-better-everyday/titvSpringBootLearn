package com.example.onetoone_uni.dao;

import com.example.onetoone_uni.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentDaoImpl implements StudentDao{
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student findStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }
}
