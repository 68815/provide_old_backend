package com.example.provide_old_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.provide_old_backend.mapper")
public class ProvideOldBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvideOldBackendApplication.class, args);
    }

}
