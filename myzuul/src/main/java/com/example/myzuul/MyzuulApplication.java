package com.example.myzuul;

import com.example.myzuul.filter.MyWordFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class MyzuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyzuulApplication.class, args);
    }

//    @Bean
//    public MyFilter1 getMyFilter11(){
//        return new MyFilter1();
//    }

    @Bean
    public MyWordFilter getMyFilter22(){
        return new MyWordFilter();
    }
}
