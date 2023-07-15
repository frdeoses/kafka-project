package com.kafka.provaider;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringBootProvaiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProvaiderApplication.class, args);
    }


    //	Para ver que manda un mensaje al iniciar el ms
    @Bean
    CommandLineRunner init(KafkaTemplate<String, String> kafkaTemplate) {
        return args ->

                kafkaTemplate.send("unProgramadorNaceTopic", "Prueba final Spring con kafka");

    }

}
