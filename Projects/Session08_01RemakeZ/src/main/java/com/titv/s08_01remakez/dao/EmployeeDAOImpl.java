package com.titv.s08_01remakez.dao;

import com.titv.s08_01remakez.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private EntityManager entityManager;
    @Autowired

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getAll() {
        String jpql = "select e from Employee e";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    public Employee getById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    @Transactional
    public Employee addEmployee(Employee employee) {
        entityManager.persist(employee);
        return employee;
    }

    @Override
//    @Transactional
    public Employee saveAndFlush(Employee employee) {
        entityManager.merge(employee);
        return employee;
    }

    @Override
//    @Transactional
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class ,id);
        entityManager.remove(employee);
    }
}
