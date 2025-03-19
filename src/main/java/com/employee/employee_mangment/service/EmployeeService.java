package com.employee.employee_mangment.service;

import com.employee.employee_mangment.dto.EmployeeDTO;
import com.employee.employee_mangment.entity.Employee;
import com.employee.employee_mangment.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee save(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSalary(employeeDTO.getSalary());
        return repository.save(employee);
    }

    public Optional<Employee> findById(int id) {
        return repository.findById(id);
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public Employee update(int id, EmployeeDTO employeeDTO) {
        Optional<Employee> existingEmployee = repository.findById(id);
        if (existingEmployee.isEmpty()) {
            throw new IllegalArgumentException("Employee with id " + id + " not found");
        }
        Employee employee = existingEmployee.get();
        employee.setName(employeeDTO.getName());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSalary(employeeDTO.getSalary());
        return repository.update(employee);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
