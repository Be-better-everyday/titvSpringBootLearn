package com.example.onetoone_uni.dao;

import com.example.onetoone_uni.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl implements CourseDao{
    private EntityManager entityManager;
    @Autowired
    public CourseDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }
}
