package com.example.footballwebproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EnableJpaAuditing
public class FootballWebProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FootballWebProjectApplication.class, args);
    }

}
