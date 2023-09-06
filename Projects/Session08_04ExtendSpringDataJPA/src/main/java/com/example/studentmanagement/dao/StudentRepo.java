package com.example.studentmanagement.dao;

import com.example.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

// *** all is new in 8.4 ***
@RepositoryRestResource(path="students")
public interface StudentRepo extends JpaRepository<Student, Integer> {
    //query by firstName
    public List<Student> findByFirstName(String firstName);

    //query by firstName and lastName
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    //query students differ from finding Value
//    public List<Student> findByFirstNameNot(String firstName);
//    @Query("SELECT s FROM Student s WHERE s.firstName <>?1")
    @Query("SELECT s FROM Student s WHERE s.firstName not like %?1%")
    public  List<Student> findByFirstNameNot(String firstName);
}
