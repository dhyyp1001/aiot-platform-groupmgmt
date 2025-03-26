package com.keti.platform_upgrade.aiot_platform_groupmgmt.kafka.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaMessageProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        System.err.println("\u274C Kafka message failed to send: " + ex.getMessage());
                    } else {
                        System.out.println("\uD83D\uDCE6 Kafka message sent to [" + topic + "] at offset " + result.getRecordMetadata().offset());
                    }
                });
    }
}
