package com.akshatsonic.codelyze.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CodeforcesKafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    @Value("${kafka.codeforces.submission.topic}")
    private String TOPIC_NAME; // Replace with your desired topic name

    public CodeforcesKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC_NAME, message);
        log.debug("Message " + message +
                " has been sucessfully sent to the topic: " + TOPIC_NAME);
    }
}
