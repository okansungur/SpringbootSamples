package com.example.tmp.monopro;

import com.example.tmp.monopro.service.StorageService;
import com.example.tmp.monopro.utility.StorageProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class MonoproApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonoproApplication.class, args);
    }
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return args ->  storageService.init();

    }
}
