package com.example.onetoone_uni.dao;

import com.example.onetoone_uni.entity.Teacher;
import com.example.onetoone_uni.entity.TeacherDetail;

public interface TeacherDetailDao {
    public void save(TeacherDetail teacherDetail);

    public TeacherDetail findTeacherDetailById(int id);
    void deleteTeacherDetailById(int id);
}
