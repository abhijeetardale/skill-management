package com.nhs.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE_SKILLS")
public class EmployeeSkills {
    @EmbeddedId
    @Id
    private EmployeeSkillId employeeSkillId;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pId")
    private Proficiency proficiency;

    public EmployeeSkills() {
    }

    public EmployeeSkills(EmployeeSkillId employeeSkillId, Proficiency proficiency) {
        this.employeeSkillId = employeeSkillId;
        this.proficiency = proficiency;
    }

    public EmployeeSkillId getEmployeeSkillId() {
        return employeeSkillId;
    }

    public void setEmployeeSkillId(EmployeeSkillId employeeSkillId) {
        this.employeeSkillId = employeeSkillId;
    }

    public Proficiency getProficiency() {
        return proficiency;
    }

    public void setProficiency(Proficiency proficiency) {
        this.proficiency = proficiency;
    }

}
