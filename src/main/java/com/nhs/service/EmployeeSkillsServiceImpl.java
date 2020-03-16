package com.nhs.service;

import com.nhs.model.EmployeeSkillId;
import com.nhs.model.EmployeeSkills;
import com.nhs.repository.EmployeeSkillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeSkillsServiceImpl  implements EmployeeSkillsService{
    @Autowired
    private EmployeeSkillsRepository employeeSkillsRepository;

    @Override
    public EmployeeSkills getEmployeeSkill(Integer eId, Integer pId) {
        return employeeSkillsRepository.findById(new EmployeeSkillId(eId, pId)).get();
    }

    @Override
    public List<EmployeeSkills> getEmployeeSkills(Integer id){

        return employeeSkillsRepository.findByEmployeeSkillIdEmpId(id);
    }

    @Override
    public String addEmployeeSkills(EmployeeSkills employeeSkills){

        EmployeeSkills savedEmployeeSkills = employeeSkillsRepository.save(employeeSkills);

        return "SUCCESS";
    }

    @Override
    public EmployeeSkills updateEmployeeSkills(EmployeeSkills employeeSkills){

        EmployeeSkills updatedEmployeeSkills = employeeSkillsRepository.save(employeeSkills);
        return updatedEmployeeSkills;
    }

    @Override
    public Map<String, String> deleteEmployeeSkill(Integer eId, Integer pId){
        Map<String, String> status = new HashMap<>();
        Optional<EmployeeSkills> employeeSkills = employeeSkillsRepository.findById(new EmployeeSkillId(eId, pId));
        if(employeeSkills.isPresent()) {
            employeeSkillsRepository.delete(employeeSkills.get());
            status.put("Status", "EmployeeSkills deleted successfully");
        }
        else {
            status.put("Status", "EmployeeSkills not exist");
        }
        return status;
    }

    @Override
    public Map<String, String> deleteEmployeeAllSkills(Integer id) {
        List<EmployeeSkills> employeeSkills = employeeSkillsRepository.findByEmployeeSkillIdEmpId(id);
        Map<String, String> status = new HashMap<>();
        if(!employeeSkills.isEmpty()) {
            employeeSkillsRepository.deleteAll(employeeSkills);
            status.put("Status", "EmployeeSkills deleted successfully");
        }
        else {
            status.put("Status", "EmployeeSkills not exist");
        }
        return status;
    }

    @Override
    public List<EmployeeSkills> getAllEmployeeSkills(){

        return employeeSkillsRepository.findAll();
    }
}
