package com.mygroup.inventorymanagementproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignedToRepository extends JpaRepository<AssignedTo, AssignedToId> {
    List<AssignedTo> findByEmployeeTcno(String tcno); //find assignments by employee TCNO
    List<AssignedTo> findByDeviceId(String deviceId);  //find assignments by device ID

}
