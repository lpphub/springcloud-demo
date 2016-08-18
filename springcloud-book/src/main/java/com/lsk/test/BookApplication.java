package com.lsk.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
//@EnableCircuitBreaker
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class, args);
        System.out.println("book-service start...");
    }
}
