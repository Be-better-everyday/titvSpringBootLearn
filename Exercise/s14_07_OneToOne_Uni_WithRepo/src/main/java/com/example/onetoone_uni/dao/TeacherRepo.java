package com.example.onetoone_uni.dao;

import com.example.onetoone_uni.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {
    @Query("select t from Teacher t " +
            "JOIN FETCH t.students " +
            "where t.id = ?1")
    public Teacher findTeacherByIdJoinFetch(int id);
}
