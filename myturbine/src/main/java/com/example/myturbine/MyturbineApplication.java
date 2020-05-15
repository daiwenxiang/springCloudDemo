package com.example.myturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableEurekaClient
@EnableTurbine
public class MyturbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyturbineApplication.class, args);
    }

}
