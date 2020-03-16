package com.nhs.controller;
import com.nhs.model.Employee;
import com.nhs.model.Organisation;
import com.nhs.repository.EmployeeRepository;
import com.nhs.repository.OrganisationRepository;
import com.nhs.service.EmployeeService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {

    @InjectMocks
    EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    @Test
    public void getEmployeeByIdShouldReturnEmployee() throws Exception {
        Employee empOne = new Employee();
        empOne.setEmpId(1);
        empOne.setEmpName("John");

        when(employeeService.getEmployeeById(1)).thenReturn(empOne);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Employee result = employeeController.getEmployee(1);

        assertThat(result.getEmpId()).isEqualTo(1);
        assertThat(result.getEmpName()).isEqualTo("John");
    }

    @Test
    public void getOrganisationsShouldReturnAllOrganisations() throws Exception {
        List<Employee> list = new ArrayList<Employee>();
        Employee empOne = new Employee();
        empOne.setEmpId(1);
        empOne.setEmpName("John");
        list.add(empOne);

        when(employeeService.getAllEmployee()).thenReturn(list);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        List<Employee> result = employeeController.getAllEmployee();

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getEmpName()).isEqualTo("John");
    }

}
