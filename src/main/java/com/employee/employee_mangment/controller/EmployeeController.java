package com.employee.employee_mangment.controller;

import com.employee.employee_mangment.entity.Employee;
import com.employee.employee_mangment.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public String save(@RequestBody Employee employee) {
        service.save(employee);
        return "Employee Saved!";
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Employee> findAll() {
        return service.findAll();
    }

    @PutMapping
    public String update(@RequestBody Employee employee) {
        service.update(employee);
        return "Employee Updated!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "Employee Deleted!";
    }
}
