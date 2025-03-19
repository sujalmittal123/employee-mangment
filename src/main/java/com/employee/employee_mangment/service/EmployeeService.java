package com.employee.employee_mangment.service;

import com.employee.employee_mangment.entity.Employee;
import com.employee.employee_mangment.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void save(Employee employee) {
        repository.save(employee);
    }

    public Employee findById(int id) {
        return repository.findById(id);
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public void update(Employee employee) {
        repository.update(employee);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}