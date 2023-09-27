package com.example.s14_08_onetomany.dao;

import com.example.s14_08_onetomany.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CourseDaoImpl implements CourseDao{
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    @Transactional
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }
}
