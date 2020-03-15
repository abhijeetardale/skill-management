package com.nhs.controller;
import com.nhs.model.Organisation;
import com.nhs.repository.OrganisationRepository;
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
public class OrganisationControllerTest {

    @InjectMocks
    OrganisationController organisationController;

    @Mock
    private OrganisationRepository organisationRepository;

    @Test
    public void getOrganisationByIdShouldReturnOrganisation() throws Exception {
        Organisation org = new Organisation();
        org.setOrgId(1);
        org.setOrgName("NHS");

        when(organisationRepository.findById(1)).thenReturn(Optional.of(org));

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Organisation result = organisationController.getOrganisationById(1);

        assertThat(result.getOrgId()).isEqualTo(1);
        assertThat(result.getOrgName()).isEqualTo("NHS");
    }

    @Test
    public void getOrganisationsShouldReturnAllOrganisations() throws Exception {
        Organisation org = new Organisation();
        org.setOrgId(1);
        org.setOrgName("NHS");
        List<Organisation> organisationList = new ArrayList<Organisation>(Arrays.asList(org));
        when(organisationRepository.findAll()).thenReturn(organisationList);

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        List<Organisation> result = organisationController.getOrganisations();

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getOrgId()).isEqualTo(1);
        assertThat(result.get(0).getOrgName()).isEqualTo("NHS");
    }

}
