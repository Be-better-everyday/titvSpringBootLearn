package com.example.demo.dao;

import com.example.demo.entity.Teacher;

public interface TeacherDAO {
    public void save(Teacher teacher);
    public Teacher findTeacherById(int id);
    public void deleteTeacherById(int id);
}
