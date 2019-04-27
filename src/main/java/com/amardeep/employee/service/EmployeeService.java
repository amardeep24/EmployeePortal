package com.amardeep.employee.service;

import com.amardeep.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee createEmployee(Employee blog);
    public Employee getEmployee(Long id);
    public List<Employee> getAllEmployees();
}
