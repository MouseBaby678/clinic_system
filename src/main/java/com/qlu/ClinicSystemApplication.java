package com.qlu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.qlu.mapper")
public class ClinicSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClinicSystemApplication.class, args);
    }

}
