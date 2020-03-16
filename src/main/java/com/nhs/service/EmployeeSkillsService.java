package com.nhs.service;

import com.nhs.model.EmployeeSkills;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface EmployeeSkillsService{

    EmployeeSkills getEmployeeSkill(Integer eId, Integer pId);

    List<EmployeeSkills> getEmployeeSkills(Integer id);

    String addEmployeeSkills(EmployeeSkills employeeSkills);

    EmployeeSkills updateEmployeeSkills(EmployeeSkills employeeSkills);

    Map<String, String> deleteEmployeeSkill(Integer eId, Integer pId);

    Map<String, String> deleteEmployeeAllSkills(Integer id);

    List<EmployeeSkills> getAllEmployeeSkills();
}
