package com.example.onetoone_uni.dao;

import com.example.onetoone_uni.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDaoImpl implements TeacherDao{
    private EntityManager entityManager;

    @Autowired
    public TeacherDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    @Transactional
    public Teacher findTeacherById(int id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    @Transactional
    public void deleteTeacherById(int id) {
        entityManager.remove(findTeacherById(id));
    }

    @Override
    @Transactional
    public void update(Teacher teacher) {
        entityManager.merge(teacher);
        entityManager.flush();
    }
}
