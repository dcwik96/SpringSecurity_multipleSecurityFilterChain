package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
//
//    @Bean
//    BearerTokenResolver bearerTokenResolver() {
//        DefaultBearerTokenResolver bearerTokenResolver = new DefaultBearerTokenResolver();
//        bearerTokenResolver.setBearerTokenHeaderName(HttpHeaders.PROXY_AUTHORIZATION);
//        return bearerTokenResolver;
//    }


}
