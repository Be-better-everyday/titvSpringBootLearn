package vn.titv.spring.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.titv.spring.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
