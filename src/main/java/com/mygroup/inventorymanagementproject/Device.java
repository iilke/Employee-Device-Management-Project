package com.mygroup.inventorymanagementproject;

import jakarta.persistence.*;

@Entity
@Table(name = "DEVICE")
public class Device {

    @Id
    @Column(name = "ID", nullable = false, length = 100)
    private String id;

    @Column(name = "type", nullable = false, length = 100)
    private String type;

    @Column(name = "brand", nullable = false, length = 100)
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private DeviceStatus status;

    @OneToOne(mappedBy = "device")
    private AssignedTo assignment;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    public AssignedTo getAssignment() {
        return assignment;
    }

    public void setAssignment(AssignedTo assignment) {
        this.assignment = assignment;
    }

    public enum DeviceStatus {
        working,
        broken,
        under_repair,
        idle
    }
}
