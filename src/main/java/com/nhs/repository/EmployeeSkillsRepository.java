package com.nhs.repository;

import com.nhs.model.EmployeeSkillId;
import com.nhs.model.EmployeeSkills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeSkillsRepository extends JpaRepository<EmployeeSkills, EmployeeSkillId> {
    List<EmployeeSkills> findByEmployeeSkillIdEmpId(Integer empId);
}
