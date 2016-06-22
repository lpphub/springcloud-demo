package com.lsk.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class SpringcloudConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConfigApplication.class, args);
        System.out.println("Config Server start...");
    }
}
