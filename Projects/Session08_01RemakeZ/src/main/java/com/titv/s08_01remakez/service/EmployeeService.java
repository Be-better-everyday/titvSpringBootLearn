package com.titv.s08_01remakez.service;

import com.titv.s08_01remakez.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAllEmployee();
    public Employee findById(int id);
    public Employee addNewEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(int id);
}
