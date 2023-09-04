package com.titv.s08_01remakez.rest;

import com.titv.s08_01remakez.dao.EmployeeDAO;
import com.titv.s08_01remakez.dao.EmployeeDAOImpl;
import com.titv.s08_01remakez.entity.Employee;
import com.titv.s08_01remakez.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.findAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee){
        employee.setId(null);
        System.out.println(employee);
        employee = employeeService.addNewEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee, @PathVariable int id){
        Employee existingEmployee = employeeService.findById(id);
        if(existingEmployee != null){
            existingEmployee.setName(employee.getName());
            existingEmployee.setPosition(employee.getPosition());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setSalary(employee.getSalary());
            employeeService.updateEmployee(existingEmployee);
            return ResponseEntity.ok(existingEmployee);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id){
        Employee existingEmployee = employeeService.findById(id);
        if(existingEmployee != null){
            employeeService.deleteEmployee(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
