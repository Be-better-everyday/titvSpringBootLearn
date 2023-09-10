package vn.titv.spring.hibernate.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.hibernate.entity.Course;

@Repository
public class CourseDAOImpl implements CourseDAO{
    private EntityManager entityManager;
    @Autowired
    public CourseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Course course) {
        entityManager.persist(course);
    }
}
