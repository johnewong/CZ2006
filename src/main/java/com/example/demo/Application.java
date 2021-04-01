package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
       // TimeZone.setDefault(TimeZone.getTimeZone("+8"));
        SpringApplication.run(Application.class, args);
    }
}
