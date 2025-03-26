package com.keti.platform_upgrade.aiot_platform_groupmgmt.repository;

import com.keti.platform_upgrade.aiot_platform_groupmgmt.model.Device;

import java.util.List;
import java.util.Optional;

public interface DeviceRepositoryCustom {
    List<Device> findAllDevices();
    Optional<Device> findDeviceById(Long id);
    Device saveDevice(Device device);
    Device updateDevice(Long id, Device device);
    void deleteDevice(Long id);
}
