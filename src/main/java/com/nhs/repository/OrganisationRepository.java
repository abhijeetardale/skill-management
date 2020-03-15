package com.nhs.repository;

import com.nhs.model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation, Integer> {
}
