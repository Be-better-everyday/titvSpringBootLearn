package vn.titv.spring.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.hibernate.entity.Course;
import vn.titv.spring.hibernate.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO{
    EntityManager entityManager;
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s "
                        + "JOIN FETCH s.courses "
                        + "where s.id = :id"
                , Student.class
        );
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public Student findStudentById(int id) {
        return entityManager.find(Student.class, id);
    }
}
