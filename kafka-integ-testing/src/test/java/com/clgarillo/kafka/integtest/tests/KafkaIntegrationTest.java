package com.clgarillo.kafka.integtest.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.utils.KafkaTestUtils;

@SpringBootTest
public class KafkaIntegrationTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    @Autowired
    private KafkaConsumer<String, String> consumer;

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @BeforeEach
    public void setup() {
        kafkaListenerEndpointRegistry.start();
    }

    @AfterEach
    public void teardown() {
        kafkaListenerEndpointRegistry.stop();
    }

    @Test
    public void testMessageConsumption() {
        // Prepare test data
        String topic = "test-topic";
        String message = "Test message 123";

        // Send a test message to the topic
        kafkaTemplate.send(topic, message);

        consumer.subscribe(Collections.singleton(topic));

        // Consume the message from the topic
        ConsumerRecord<String, String> consumedRecord = KafkaTestUtils.getSingleRecord(consumer, topic);

        // Assert the consumed message matches the sent message
        System.out.println(consumedRecord.value() + "  <====>   " +  message);
        assertThat(consumedRecord.value()).isEqualTo(message);
    }

}
