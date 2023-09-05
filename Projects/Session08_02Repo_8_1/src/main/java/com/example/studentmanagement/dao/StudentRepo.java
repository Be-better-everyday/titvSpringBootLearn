package com.example.studentmanagement.dao;

import com.example.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path="students")
public interface StudentRepo extends JpaRepository<Student, Integer> {
}
