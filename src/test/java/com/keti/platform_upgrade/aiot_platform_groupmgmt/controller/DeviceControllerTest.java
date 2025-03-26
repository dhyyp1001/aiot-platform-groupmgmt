package com.keti.platform_upgrade.aiot_platform_groupmgmt.controller;

import com.keti.platform_upgrade.aiot_platform_groupmgmt.model.Device;
import com.keti.platform_upgrade.aiot_platform_groupmgmt.repository.DeviceRepository;
import com.keti.platform_upgrade.aiot_platform_groupmgmt.service.DeviceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DeviceServiceTest {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private DeviceService deviceService;

    private Device device;

    @BeforeEach
    void setUp() {
        device = Device.builder()
                .device_name("UnitTestDevice")
                .device_type("sensor")
                .device_description("real db test")
                .build();
    }

    @Test
    void testCreateDevice() {
        Device saved = deviceService.createDevice(device);

        assertNotNull(saved);
        assertNotNull(saved.getDevice_id());
        assertEquals("UnitTestDevice", saved.getDevice_name());
    }

    @Test
    void testGetDeviceById() {
        Device saved = deviceService.createDevice(device);
        Optional<Device> found = deviceService.getDeviceById(saved.getDevice_id());

        assertTrue(found.isPresent());
        assertEquals("UnitTestDevice", found.get().getDevice_name());
    }

    @Test
    void testDeleteDevice() {
        Device saved = deviceService.createDevice(device);
        deviceService.deleteDevice(saved.getDevice_id());

        Optional<Device> deleted = deviceService.getDeviceById(saved.getDevice_id());
        assertTrue(deleted.isEmpty());
    }
}
