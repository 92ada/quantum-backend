package com.techncat.quantum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan("com.techncat.quantum.app")
public class QuantumApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuantumApplication.class, args);
    }

}
