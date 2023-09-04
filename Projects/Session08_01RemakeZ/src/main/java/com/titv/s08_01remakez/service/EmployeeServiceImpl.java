package com.titv.s08_01remakez.service;

import com.titv.s08_01remakez.dao.EmployeeDAO;
import com.titv.s08_01remakez.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employeeDAO.getAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.getById(id);
    }

    @Override
    @Transactional
    public Employee addNewEmployee(Employee employee) {
        return employeeDAO.addEmployee(employee);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.saveAndFlush(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteById(id);
    }
}
