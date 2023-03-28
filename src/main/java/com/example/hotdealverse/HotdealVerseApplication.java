package com.example.hotdealverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HotdealVerseApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotdealVerseApplication.class, args);
    }

}
