package vn.titv.spring.hibernate.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.titv.spring.hibernate.entity.Course;
import vn.titv.spring.hibernate.entity.Teacher;

@Repository
public class TeacherDAOImpl implements TeacherDAO{
    private EntityManager entityManager;

    @Autowired
    public TeacherDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    public Teacher findTeacherById(int id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    @Transactional
    public void deleteTeacherById(int id) {
        // find
        Teacher teacher = entityManager.find(Teacher.class, id);

        // delete
        entityManager.remove(teacher);
    }

    @Override
    @Transactional
    public void updateTeacher(Teacher teacher) {
        entityManager.merge(teacher);
        entityManager.flush();
    }

    @Override
    public Teacher findTeacherByIdJoinFetch(int id) {
        TypedQuery<Teacher> query = entityManager.createQuery(
                "select t from Teacher t "
                + "JOIN FETCH t.courses "
                + "JOIN FETCH t.teacherDetail "
                + "where t.id = :id"
                , Teacher.class
        );
        query.setParameter("id", id);

        Teacher teacher = null;
        try {
            teacher = query.getSingleResult();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return teacher;
    }
}
