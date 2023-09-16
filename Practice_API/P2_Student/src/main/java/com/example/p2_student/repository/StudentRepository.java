package com.example.p2_student.repository;

import com.example.p2_student.entity.Student2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource (collectionResourceRel = "tmpStudents", path = "students")
public interface StudentRepository extends JpaRepository<Student2, Integer> {
    public List<Student2> findByFirstName(@Param("firstName") String firstName);

    public List<Student2> findByFirstNameContainingAndIdLessThan(String firstName, int id);
}
