package com.nhs.controller;

import com.nhs.model.Employee;
import com.nhs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    Employee getEmployee(@PathVariable Integer id){

        return  employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee")
    String addEmployee(@RequestBody Employee employee){

        return employeeService.addEmployee(employee);
    }

    @PutMapping("/employee")
    Employee updateEmployee(@RequestBody Employee employee){

        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employee")
    Map<String, String> deleteEmployee(@RequestParam Integer id){

        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

}

