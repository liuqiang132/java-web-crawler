package com.liuqiang.webmagic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //开启任务
public class CrawlerWebMagicJdApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrawlerWebMagicJdApplication.class, args);
    }

}
