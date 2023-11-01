package com.liuqiang.job51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Crawler51jobApplication {

    public static void main(String[] args) {
        SpringApplication.run(Crawler51jobApplication.class, args);
    }

}
