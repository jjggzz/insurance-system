package com.insurance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.insurance.business.mapper")
@SpringBootApplication(scanBasePackages = {"com.springboot.simple","com.insurance.business"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
