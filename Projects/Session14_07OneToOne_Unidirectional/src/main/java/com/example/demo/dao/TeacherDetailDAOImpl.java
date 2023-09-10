package com.example.demo.dao;

import com.example.demo.entity.Teacher;
import com.example.demo.entity.TeacherDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDetailDAOImpl implements TeacherDetailDAO{
    private EntityManager entityManager;
@Autowired
    public TeacherDetailDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(TeacherDetail teacherDetail) {
        entityManager.persist(teacherDetail);
    }
}
