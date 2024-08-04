package com.mygroup.inventorymanagementproject;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    public Device addDevice(Device device) {

        if (device.getId() == null || device.getId().isEmpty()) {
            throw new IllegalArgumentException("Device ID cannot be null or empty");
        }
        return deviceRepository.save(device);
    }

    public Optional<Device> getDeviceById(String id) {
        return deviceRepository.findById(id);
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Device editDevice(String id, Device updatedDevice) {
        Optional<Device> deviceOptional = deviceRepository.findById(id);
        if (deviceOptional.isPresent()) {
            Device device = deviceOptional.get();
            device.setType(updatedDevice.getType());
            device.setBrand(updatedDevice.getBrand());
            device.setStatus(updatedDevice.getStatus());
            return deviceRepository.save(device);
        }
        return null;
    }

    public void deleteDevice(String id) {
        if (deviceRepository.existsById(id)) {
            deviceRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Device not found with id: " + id);
        }
    }
}
