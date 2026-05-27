package com.employee.employee_service.controller;

import com.employee.employee_service.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/employees")
@CrossOrigin("*")
public class EmployeeController {

    private final Map<Long, Employee> employeeDB = new HashMap<>();

    public EmployeeController() {
        employeeDB.put(1L, new Employee(1L, "Rahul", 1200));
    }

    @GetMapping
    public java.util.Collection<Employee> getAllEmployees() {
        return employeeDB.values();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeDB.getOrDefault(id, new Employee(id, "Unknown", 0));
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeDB.put(employee.getId(), employee);
        return employee;
    }
}