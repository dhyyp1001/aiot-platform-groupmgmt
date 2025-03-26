package com.keti.platform_upgrade.aiot_platform_groupmgmt.kafka.controller;

import com.keti.platform_upgrade.aiot_platform_groupmgmt.kafka.producer.KafkaMessageProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final KafkaMessageProducer kafkaMessageProducer;

    public KafkaController(KafkaMessageProducer kafkaMessageProducer) {
        this.kafkaMessageProducer = kafkaMessageProducer;
    }

    @GetMapping("/kafka/send")
    public String sendMessage() {
        kafkaMessageProducer.sendMessage("test-topic", "Hello from Spring Boot without Consumer!");
        return "Kafka 메시지 전송 완료!";
    }
}
