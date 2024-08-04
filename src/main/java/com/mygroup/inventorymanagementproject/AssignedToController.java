package com.mygroup.inventorymanagementproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/assignments")
public class AssignedToController {

    @Autowired
    private AssignedToService assignedToService;

    @PostMapping
    public ResponseEntity<AssignedTo> assignDeviceToEmployee(@RequestParam String etcno, @RequestParam String did) {
        AssignedTo assignedTo = assignedToService.assignDeviceToEmployee(etcno, did);
        if (assignedTo != null) {
            return new ResponseEntity<>(assignedTo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<AssignedTo> updateRevokedDate(@RequestParam String etcno, @RequestParam String did, @RequestParam String revokedDate) {
        java.sql.Date sqlRevokedDate = java.sql.Date.valueOf(revokedDate); // Convert string to SQL date
        AssignedTo updatedAssignment = assignedToService.updateRevokedDate(etcno, did, sqlRevokedDate);
        if (updatedAssignment != null) {
            return new ResponseEntity<>(updatedAssignment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
