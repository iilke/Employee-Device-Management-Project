package com.mygroup.inventorymanagementproject;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        try {
            Device savedDevice = deviceService.addDevice(device);
            return new ResponseEntity<>(savedDevice, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable String id) {
        Optional<Device> deviceOptional = deviceService.getDeviceById(id);
        return deviceOptional.map(device -> new ResponseEntity<>(device, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices() {
        List<Device> devices = deviceService.getAllDevices();
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable String id, @RequestBody Device updatedDevice) {
        Device updated = deviceService.editDevice(id, updatedDevice);
        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable String id) {
        try {
            deviceService.deleteDevice(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
