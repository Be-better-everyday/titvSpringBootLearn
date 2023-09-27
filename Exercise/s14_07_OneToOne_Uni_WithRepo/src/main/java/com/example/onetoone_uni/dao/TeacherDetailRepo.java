package com.example.onetoone_uni.dao;

import com.example.onetoone_uni.entity.TeacherDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDetailRepo extends JpaRepository<TeacherDetail, Integer> {

}
