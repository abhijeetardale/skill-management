package com.nhs.controller;

import com.nhs.model.Organisation;
import com.nhs.repository.OrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrganisationController {

    @Autowired
    private OrganisationRepository organisationRepository;

    @GetMapping(value = "/organisation/{id}")
    Organisation getOrganisationById(@PathVariable Integer id){
        return  organisationRepository.findById(id).get();
    }

}
