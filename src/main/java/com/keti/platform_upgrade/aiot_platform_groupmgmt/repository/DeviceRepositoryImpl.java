package com.keti.platform_upgrade.aiot_platform_groupmgmt.repository;

import com.keti.platform_upgrade.aiot_platform_groupmgmt.model.Device;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DeviceRepositoryImpl implements DeviceRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Device> findAllDevices() {
        return em.createQuery("SELECT d FROM Device d", Device.class).getResultList();
    }

    @Override
    public Optional<Device> findDeviceById(Long id) {
        return Optional.ofNullable(em.find(Device.class, id));
    }

    @Override
    public Device saveDevice(Device device) {
        em.persist(device);
        return device;
    }

    @Override
    public Device updateDevice(Long id, Device newDevice) {
        Device existing = em.find(Device.class, id);
        if (existing == null) return null;

        existing.setDevice_name(newDevice.getDevice_name());
        existing.setDevice_type(newDevice.getDevice_type());
        existing.setDevice_description(newDevice.getDevice_description());

        return existing;
    }

    @Override
    public void deleteDevice(Long id) {
        Device device = em.find(Device.class, id);
        if (device != null) {
            em.remove(device);
        }
    }
}