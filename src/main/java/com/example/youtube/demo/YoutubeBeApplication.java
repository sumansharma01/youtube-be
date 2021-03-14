package com.example.youtube.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class YoutubeBeApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoutubeBeApplication.class, args);
    }

}
