package com.nhs.controller;

import com.nhs.model.EmployeeSkills;
import com.nhs.service.EmployeeSkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeSkillsController {
    @Autowired
    private EmployeeSkillsService employeeSkillsService;


    @RequestMapping(value = "/employee-skill/{eId}/{pId}", method = RequestMethod.GET)
    EmployeeSkills getEmployeeSkill(@PathVariable Integer eId, @PathVariable Integer pId){

        return  employeeSkillsService.getEmployeeSkill(eId, pId);
    }

    @RequestMapping(value = "/employee-skills/{id}", method = RequestMethod.GET)
    List<EmployeeSkills> getEmployeeSkills(@PathVariable Integer id){

        return employeeSkillsService.getEmployeeSkills(id);
    }

    @RequestMapping(value = "/employee-skills", method = RequestMethod.POST)
    String addEmployeeSkills(@RequestBody EmployeeSkills employeeSkills){

        return employeeSkillsService.addEmployeeSkills(employeeSkills);
    }

    @RequestMapping(value = "/employee-skills", method = RequestMethod.PUT)
    EmployeeSkills updateEmployeeSkills(@RequestBody EmployeeSkills employeeSkills){

        return employeeSkillsService.updateEmployeeSkills(employeeSkills);
    }

    @RequestMapping(value = "/employee-skills/{eId}/{pId}", method = RequestMethod.DELETE)
    Map<String, String> deleteEmployeeSkill(@RequestParam Integer eId, @PathVariable Integer pId) {

        return employeeSkillsService.deleteEmployeeSkill(eId, pId);
    }

    @RequestMapping(value = "/employee-skills/{id}", method = RequestMethod.DELETE)
    Map<String, String> deleteEmployeeAllSkills(@RequestParam Integer id){

        return employeeSkillsService.deleteEmployeeAllSkills(id);
    }

    @RequestMapping(value = "/employee-skills", method = RequestMethod.GET)
    List<EmployeeSkills> getAllEmployeeSkills(){

        return employeeSkillsService.getAllEmployeeSkills();
    }

}

