package com.example.demo.dao;

import com.example.demo.entity.TeacherDetail;

public interface TeacherDetailDAO {
    public void save(TeacherDetail teacherDetail);
    public TeacherDetail findTeacherDetailById(int id);
    public void deleteTeacherDetailById(int id);
}
