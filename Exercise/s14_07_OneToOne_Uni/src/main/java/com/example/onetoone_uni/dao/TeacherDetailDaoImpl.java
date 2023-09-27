package com.example.onetoone_uni.dao;

import com.example.onetoone_uni.entity.Teacher;
import com.example.onetoone_uni.entity.TeacherDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDetailDaoImpl implements TeacherDetailDao{
    private EntityManager entityManager;
    @Autowired
    public TeacherDetailDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(TeacherDetail teacherDetail) {
        entityManager.persist(teacherDetail);
    }

    @Override
    @Transactional
    public TeacherDetail findTeacherDetailById(int id) {
        return entityManager.find(TeacherDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteTeacherDetailById(int id) {
        entityManager.remove(findTeacherDetailById(id));
    }
}
