package com.nhs.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ORGANISATION")
public class Organisation implements Serializable {

    @Column(name = "orgId")
    @Id
    Integer orgId;

    @Column(name = "orgName")
    String orgName;

    @OneToMany(mappedBy="empId", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Employee> employees;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}