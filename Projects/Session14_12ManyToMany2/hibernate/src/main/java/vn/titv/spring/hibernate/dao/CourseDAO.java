package vn.titv.spring.hibernate.dao;

import vn.titv.spring.hibernate.entity.Course;

import java.util.List;


public interface CourseDAO {
    public void save(Course course);
    public List<Course> findCoursesByTeacherId(int id);
    public Course findCourseById(int id);

    public Course findCourseAndStudentByCourseId (int id);
}
