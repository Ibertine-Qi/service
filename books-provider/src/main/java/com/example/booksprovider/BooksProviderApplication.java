package com.example.booksprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.example.booksprovider.dao")
public class BooksProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksProviderApplication.class, args);
    }

}
