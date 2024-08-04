package com.mygroup.inventorymanagementproject;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @Column(name = "TCNO", nullable = false, length = 10)
    private String tcno;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "surname", nullable = false, length = 100)
    private String surname;

    @Column(name = "landing_on_job_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date landingOnJobDate;

    @Column(name = "quiting_job_date")
    @Temporal(TemporalType.DATE)
    private Date quitingJobDate;

    @OneToMany(mappedBy = "employee")
    private Set<AssignedTo> assignments;


    public String getTcno() {
        return tcno;
    }

    public void setTcno(String tcno) {
        this.tcno = tcno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getLandingOnJobDate() {
        return landingOnJobDate;
    }

    public void setLandingOnJobDate(Date landingOnJobDate) {
        this.landingOnJobDate = landingOnJobDate;
    }

    public Date getQuitingJobDate() {
        return quitingJobDate;
    }

    public void setQuitingJobDate(Date quitingJobDate) {
        this.quitingJobDate = quitingJobDate;
    }

    public Set<AssignedTo> getAssignments() {
        return assignments;
    }

    public void setAssignments(Set<AssignedTo> assignments) {
        this.assignments = assignments;
    }
}
