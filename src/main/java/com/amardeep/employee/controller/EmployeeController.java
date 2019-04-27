package com.amardeep.employee.controller;

import com.amardeep.employee.entity.Employee;
import com.amardeep.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@CrossOrigin
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @GetMapping(value="employee",produces= MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = empService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @PostMapping(value="employee", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Employee> createEmployee(@RequestBody Employee employee, UriComponentsBuilder builder){
        Employee employeeCreated = empService.createEmployee(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/employee/{id}").buildAndExpand(employeeCreated.getId()).toUri());
        return new ResponseEntity<>(employeeCreated,headers,HttpStatus.CREATED);
    }
}
