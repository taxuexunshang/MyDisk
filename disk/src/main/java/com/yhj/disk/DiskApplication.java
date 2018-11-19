package com.yhj.disk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yhj.disk.mapper")
public class DiskApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiskApplication.class, args);
    }
}
