package vn.titv.spring.mvcdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.titv.spring.mvcdemo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
