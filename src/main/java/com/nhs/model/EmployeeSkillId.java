package com.nhs.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EmployeeSkillId implements Serializable {
    @Column(name = "empId")
    Integer empId;

    @Column(name = "sId")
    Integer sId;

    public EmployeeSkillId() {
    }

    public EmployeeSkillId(Integer empId, Integer sId) {
        this.empId = empId;
        this.sId = sId;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }
}
