package com.mygroup.inventorymanagementproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

@Service
public class AssignedToService {

    @Autowired
    private AssignedToRepository assignedToRepository;

    public AssignedTo assignDeviceToEmployee(String etcno, String did) {
        AssignedToId assignedToId = new AssignedToId(etcno, did);
        AssignedTo assignedTo = new AssignedTo();
        assignedTo.setId(assignedToId);
        assignedTo.setAssignedDate(new java.sql.Date(System.currentTimeMillis()));

        Employee employee = new Employee();
        employee.setTcno(etcno);
        Device device = new Device();
        device.setId(did);
        assignedTo.setEmployee(employee);
        assignedTo.setDevice(device);
        return assignedToRepository.save(assignedTo);
    }

    public AssignedTo updateRevokedDate(String etcno, String did, Date revokedDate) {
        AssignedToId assignedToId = new AssignedToId(etcno, did);
        Optional<AssignedTo> assignedToOptional = assignedToRepository.findById(assignedToId);
        if (assignedToOptional.isPresent()) {
            AssignedTo assignedTo = assignedToOptional.get();
            assignedTo.setRevokedDate(revokedDate);
            return assignedToRepository.save(assignedTo);
        }
        return null;
    }
}
