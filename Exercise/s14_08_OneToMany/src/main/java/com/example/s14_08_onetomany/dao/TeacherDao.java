package com.example.s14_08_onetomany.dao;

import com.example.s14_08_onetomany.entity.Teacher;

public interface TeacherDao {
    public void save(Teacher teacher);
    public Teacher findTeacherById(int id);
    public void update(Teacher teacher);
    public Teacher findTeacherByIdJoinFetch(int id);
}
