package com.keti.platform_upgrade.aiot_platform_groupmgmt.repository;

import com.keti.platform_upgrade.aiot_platform_groupmgmt.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long>, DeviceRepositoryCustom {
}
