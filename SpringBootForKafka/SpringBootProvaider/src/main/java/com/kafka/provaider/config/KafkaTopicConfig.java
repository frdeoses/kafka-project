package com.kafka.provaider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic generateTopic() {
        Map<String, String> configurations = new HashMap<>();

//        delete (borra el mensaje), compact (Mantiene el más actual)
        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG, TopicConfig.CLEANUP_POLICY_DELETE);

        // Lo guarda durante 1 dia (Después lo borra o mantiene el más actual)
        configurations.put(TopicConfig.RETENTION_MS_CONFIG, "86400000");

        // Tamaño maximo del segmento (Defecto 1 GB)
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824");

        // Tamaño maximo de cada mensaje (Por defecto 1Mb)
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG, "1000012");

        return TopicBuilder.name("unProgramadorNaceTopic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
