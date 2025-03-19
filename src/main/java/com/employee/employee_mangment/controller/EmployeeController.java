package com.employee.employee_mangment.controller;

import com.employee.employee_mangment.dto.EmployeeDTO;
import com.employee.employee_mangment.entity.Employee;
import com.employee.employee_mangment.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public String save(@RequestBody EmployeeDTO employeeDTO) {
        service.save(employeeDTO);
        return "Employee Saved!";
    }

    @GetMapping("/{id}")
    public Optional<Employee> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Employee> findAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        service.update(id, employeeDTO);
        return "Employee Updated!";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.deleteById(id);
        return "Employee Deleted!";
    }
}
