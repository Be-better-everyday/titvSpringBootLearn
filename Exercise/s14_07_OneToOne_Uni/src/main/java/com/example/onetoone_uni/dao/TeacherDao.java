package com.example.onetoone_uni.dao;


import com.example.onetoone_uni.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDao {
    public void save(Teacher teacher);
    public Teacher findTeacherById(int id);
    void deleteTeacherById(int id);
    void update(Teacher teacher);
}
