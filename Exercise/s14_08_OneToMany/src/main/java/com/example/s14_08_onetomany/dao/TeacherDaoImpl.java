package com.example.s14_08_onetomany.dao;

import com.example.s14_08_onetomany.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TeacherDaoImpl implements TeacherDao{
    private EntityManager entityManager;
    @Override
    @Transactional
    public void save(Teacher teacher) {
        entityManager.persist(teacher);
    }

    @Override
    @Transactional
    public Teacher findTeacherById(int id) {
        return entityManager.find(Teacher.class, id);
    }

    @Override
    @Transactional
    public void update(Teacher teacher) {
        entityManager.merge(teacher);
    }

    @Override
    public Teacher findTeacherByIdJoinFetch(int id) {
        TypedQuery<Teacher> query = entityManager.createQuery(
                "SELECT t FROM Teacher t "
                + "JOIN FETCH t.courses "
                + "WHERE t.id = :id", Teacher.class
        );
        query.setParameter("id", id);
        Teacher teacher = null;
        try{
            teacher = query.getSingleResult();
        }catch( Exception ex){
            throw new RuntimeException(ex);
        }
        return teacher;
    }
}
