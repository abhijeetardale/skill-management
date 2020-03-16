package com.nhs.repository;

import com.nhs.model.Employee;
import com.nhs.model.EmployeeSkillId;
import com.nhs.model.EmployeeSkills;
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
public class EmployeeSkillsRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProficiencyRepository proficiencyRepository;

    @Autowired
    private EmployeeSkillsRepository employeeSkillsRepository;

    @Test
    @Sql("/create-and-insert-h2.sql")
    public void givenEmptyDBWhenFindOneByIdThenReturnEmptyOptional() {
        Optional<EmployeeSkills> skill = employeeSkillsRepository.findById(new EmployeeSkillId(1,1));

        assertThat(skill.isPresent()).isEqualTo(false);
    }

    @Test
    @Sql("/create-and-insert-h2.sql")
    public void givenDataFindByIdThenReturnOneOptionalRecord() {

        Optional<EmployeeSkills> skill = employeeSkillsRepository.findById(new EmployeeSkillId(111,31));

        assertThat(skill.isPresent()).isEqualTo(true);
        assertThat(skill.get().getEmployeeSkillId().getEmpId()).isEqualTo(111);
        assertThat(skill.get().getEmployeeSkillId().getsId()).isEqualTo(31);
    }

    @After
    public void cleanUp() {
        employeeRepository.deleteAll();
    }

}
