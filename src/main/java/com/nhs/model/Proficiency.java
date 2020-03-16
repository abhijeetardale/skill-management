package com.nhs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PROFICIENCY")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Proficiency implements Serializable {
    @Column(name = "pId")
    @Id
    Integer pId;

    @Column(name = "pName")
    String pName;


    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

}
