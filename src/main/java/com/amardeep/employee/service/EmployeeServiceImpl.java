package com.amardeep.employee.service;

import com.amardeep.employee.entity.Employee;
import com.amardeep.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository empRepository;

    @Override
    public Employee createEmployee(Employee emp) {
        return empRepository.save(emp);
    }

    @Override
    public Employee getEmployee(Long id) {
        return empRepository.getOne(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return empRepository.findAll();
    }
}
