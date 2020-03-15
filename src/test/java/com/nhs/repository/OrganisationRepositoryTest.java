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
public class OrganisationRepositoryTest {

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

    @Test
    @Sql("/create-h2.sql")
    public void givenDataFindByIdThenReturnOneOptionalRecord() {
        Organisation org = new Organisation();
        org.setOrgId(1);
        org.setOrgName("NHS");
        organisationRepository.save(org);
        Optional<Organisation> organisation = organisationRepository.findById(1);

        assertThat(organisation.isPresent()).isEqualTo(true);
    }

    @After
    public void cleanUp() {
        organisationRepository.deleteAll();
    }

}
