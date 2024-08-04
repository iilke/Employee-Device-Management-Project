package com.mygroup.inventorymanagementproject;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ASSIGNED_TO")
public class AssignedTo {

    @EmbeddedId
    private AssignedToId id;

    @ManyToOne
    @MapsId("etcno")
    @JoinColumn(name = "ETCNO")
    private Employee employee;

    @OneToOne
    @MapsId("did")
    @JoinColumn(name = "DID")
    private Device device;

    @Column(name = "assigned_date", nullable = false)
    private Date assignedDate;

    @Column(name = "revoked_date")
    private Date revokedDate;


    public AssignedToId getId() {
        return id;
    }

    public void setId(AssignedToId id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public Date getRevokedDate() {
        return revokedDate;
    }

    public void setRevokedDate(Date revokedDate) {
        this.revokedDate = revokedDate;
    }
}
