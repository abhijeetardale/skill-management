package com.nhs.repository;

import com.nhs.model.Proficiency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProficiencyRepository extends JpaRepository<Proficiency, Integer> {
}
