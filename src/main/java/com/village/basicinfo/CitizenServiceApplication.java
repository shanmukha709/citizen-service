package com.village.basicinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.village")
@ComponentScan(basePackages = {
        "com.village.basicinfo",
        "com.village.area" // ✅ include new area package
})
@EntityScan(basePackages = {
        "com.village.basicinfo.entity",
        "com.village.area.entity" // ✅ update
})
@EnableJpaRepositories(basePackages = {
        "com.village.basicinfo.repository",
        "com.village.area.repository" // ✅ update
})

@EnableFeignClients
public class CitizenServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CitizenServiceApplication.class, args);
    }
}
