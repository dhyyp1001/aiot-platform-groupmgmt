package com.keti.platform_upgrade.aiot_platform_groupmgmt.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long device_id;

    @Column(nullable = false, length = 100)
    private String device_name;

    @Column(length = 50)
    private String device_type;

    @Column(columnDefinition = "TEXT")
    private String device_description;
}