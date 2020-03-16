package com.nhs.service;

import com.nhs.model.Employee;
import com.nhs.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(Integer id){

        return employeeRepository.findById(id).get();
    }

    @Override
    public String addEmployee(Employee employee){
        Employee savedEmployee = employeeRepository.save(employee);
        return "SUCCESS";
    }

    @Override
    public Employee updateEmployee(Employee employee){
        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    @Override
    public Map<String, String> deleteEmployee(Integer id){
        Map<String, String> status = new HashMap<>();
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()) {
            employeeRepository.delete(employee.get());
            status.put("Status", "Employee deleted successfully");
        }
        else {
            status.put("Status", "Employee not exist");
        }
        return status;
    }

    @Override
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

}

