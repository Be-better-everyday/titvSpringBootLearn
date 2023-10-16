package com.example.demo.repo;

import com.example.demo.entity.School;
import com.example.demo.entity.TClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TClassRepository extends JpaRepository<TClass, Integer> {

    public List<TClass> findBySchool(School school);
}
