package com.nhs.repository;

import com.nhs.model.Employee;
import com.nhs.model.Organisation;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private OrganisationRepository organisationRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @Sql("/create-h2.sql")
    public void givenEmptyDBWhenFindOneByIdThenReturnEmptyOptional() {
        Optional<Employee> organisation = employeeRepository.findById(1);

        assertThat(organisation.isPresent()).isEqualTo(false);
    }

    @Test
    @Sql("/create-h2.sql")
    public void givenDataSaveShouldPersistRecordAndFindByIdThenReturnOneOptionalRecord() {
        Organisation org = new Organisation();
        org.setOrgId(1);
        org.setOrgName("NHS");
        Employee emp = new Employee();
        emp.setEmpId(1);
        emp.setEmpName("Emp1");
        emp.setOrganisation(org);

        organisationRepository.save(org);
        employeeRepository.save(emp);
        Optional<Employee> organisation = employeeRepository.findById(1);

        assertThat(organisation.isPresent()).isEqualTo(true);
        assertThat(organisation.get().getEmpName()).isEqualTo("Emp1");
    }

    @Test
    @Sql("/create-h2.sql")
    public void givenListOFDataSaveAllShouldPersistRecordAndFindByIdThenReturnOneOptionalRecord() {
        Organisation org = new Organisation();
        org.setOrgId(1);
        org.setOrgName("NHS");
        Employee emp1 = new Employee();
        emp1.setEmpId(1);
        emp1.setEmpName("Emp1");
        emp1.setOrganisation(org);
        Employee emp2 = new Employee();
        emp2.setEmpId(2);
        emp2.setEmpName("Emp2");
        emp2.setOrganisation(org);
        List<Employee> employeeList = new ArrayList<Employee>(Arrays.asList(emp1, emp2));
        organisationRepository.save(org);
        employeeRepository.saveAll(employeeList);
        List<Employee> organisations = employeeRepository.findAll();

        assertThat(organisations.size()).isEqualTo(2);
        assertThat(organisations.get(0).getEmpName()).isEqualTo("Emp1");
        assertThat(organisations.get(1).getEmpName()).isEqualTo("Emp2");
    }

    @After
    public void cleanUp() {
        employeeRepository.deleteAll();
    }

}
