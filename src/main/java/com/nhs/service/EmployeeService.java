package com.nhs.service;

import com.nhs.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService{

    Employee getEmployeeById(Integer id);

    String addEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Map<String, String> deleteEmployee(Integer id);

    List<Employee> getAllEmployee();

}
