package com.keti.platform_upgrade.aiot_platform_groupmgmt.service;

import com.keti.platform_upgrade.aiot_platform_groupmgmt.model.Device;
import com.keti.platform_upgrade.aiot_platform_groupmgmt.repository.DeviceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAllDevices();
    }

    public Optional<Device> getDeviceById(Long id) {
        return deviceRepository.findDeviceById(id);
    }

    public Device createDevice(Device device) {
        return deviceRepository.saveDevice(device);
    }

    public Device updateDevice(Long id, Device device) {
        return deviceRepository.updateDevice(id, device);
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteDevice(id);
    }
}
