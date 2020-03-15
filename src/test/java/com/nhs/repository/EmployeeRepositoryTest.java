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
    public void givenDataFindByIdThenReturnOneOptionalRecord() {
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

    @After
    public void cleanUp() {
        employeeRepository.deleteAll();
    }

}
