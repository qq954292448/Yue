package com.diaoruifeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigYueApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigYueApplication.class,args);
    }
}
