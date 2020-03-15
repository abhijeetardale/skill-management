package com.nhs.repository;

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
public class OrganisationRepositoryTests {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    private OrganisationRepository organisationRepository;

    @Test
    @Sql("/create-h2.sql")
    public void givenEmptyDBWhenFindOneByIdThenReturnEmptyOptional() {
        Optional<Organisation> organisation = organisationRepository.findById(1);

        assertThat(organisation.isPresent()).isEqualTo(false);
    }


    @After
    public void cleanUp() {
        organisationRepository.deleteAll();
    }

}
