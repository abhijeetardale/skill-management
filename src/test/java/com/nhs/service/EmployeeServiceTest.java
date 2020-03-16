package com.nhs.service;

import com.nhs.model.Employee;
import com.nhs.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeServiceTest {
    @InjectMocks
    EmployeeService employeeService = new EmployeeServiceImpl();

    @Mock
    EmployeeRepository employeeRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void getEmployeesByIdShouldReturnRecord()
    {
        Employee empOne = new Employee();
        empOne.setEmpId(1);
        empOne.setEmpName("John");

        when(employeeRepository.findById(1)).thenReturn(Optional.of(empOne));

        Employee empList = employeeService.getEmployeeById(1);

        assertEquals(empList.getEmpName(), "John");
        verify(employeeRepository, times(1)).findById(1);
    }


    @Test
    public void getAllEmployeesShouldReturnMultipleRecords()
    {
        List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee();
        empOne.setEmpId(1);
        empOne.setEmpName("John");
        Employee empTwo = new Employee();
        empOne.setEmpId(2);
        empOne.setEmpName("Alex");
        list.add(empOne);
        list.add(empTwo);

        when(employeeRepository.findAll()).thenReturn(list);

        List<Employee> empList = employeeService.getAllEmployee();

        assertEquals(2, empList.size());
        verify(employeeRepository, times(1)).findAll();
    }


    @Test
    public void addEmployeeShouldReturnSuccess()
    {
        Employee empOne = new Employee();
        empOne.setEmpId(1);
        empOne.setEmpName("John");

        when(employeeRepository.save(empOne)).thenReturn(empOne);

        String status = employeeService.addEmployee(empOne);

        assertEquals("SUCCESS", status);
        verify(employeeRepository, times(1)).save(empOne);
    }


    @Test
    public void updateEmployeeShouldReturnSuccess()
    {
        Employee empOne = new Employee();
        empOne.setEmpId(1);
        empOne.setEmpName("John");
        Employee empTwo = new Employee();
        empTwo.setEmpId(1);
        empTwo.setEmpName("John X");

        when(employeeRepository.save(empOne)).thenReturn(empTwo);

        Employee updated= employeeService.updateEmployee(empOne);

        assertEquals(updated.getEmpName(), "John X");
        verify(employeeRepository, times(1)).save(empOne);
    }

}
