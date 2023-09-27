package com.example.s14_08_onetomany.dao;

import com.example.s14_08_onetomany.entity.Course;

public interface CourseDao {
    public void save(Course course);
    public Course findCourseById(int id);
    public void update(Course course);
}
