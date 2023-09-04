package com.titv.s08_01remakez.dao;

import com.titv.s08_01remakez.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAll();
    public Employee getById(int id);
    public Employee addEmployee(Employee employee);
    public Employee saveAndFlush(Employee employee);
    public void deleteById(int id);
}
