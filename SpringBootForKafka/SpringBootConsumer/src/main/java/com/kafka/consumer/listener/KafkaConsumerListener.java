package com.kafka.consumer.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
@Slf4j
public class KafkaConsumerListener {

    @KafkaListener(topics = {"unProgramadorNaceTopic"}, groupId = "my-group-id")
    public void listener(String message) {
        log.info("Mensaje recibido, el mensaje es: " + message);
    }


}
