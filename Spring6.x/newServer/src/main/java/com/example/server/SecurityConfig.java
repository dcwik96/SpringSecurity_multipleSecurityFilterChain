package com.example.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    @Order(1)
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.securityMatcher("/all")
                .authorizeHttpRequests()
                .anyRequest()
                .permitAll();

        return httpSecurity.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain securityFilterChain2(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .securityMatcher("/securedWithToken")
                .addFilter(bearerHeaderFilter())
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
        ;
        return httpSecurity.build();
    }

    @Bean
    @Order(3)
    public SecurityFilterChain securityFilterChain3(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .securityMatcher("/securedWithUser")
                .addFilter(basicHeaderFilter())
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
        ;

        return httpSecurity.build();
    }

    private BasicHeaderFilter basicHeaderFilter() {
        BasicHeaderFilter filter = new BasicHeaderFilter();
        filter.setAuthenticationManager(authenticationManager());
        return filter;

    }

    @Bean
    public BearerHeaderFilter bearerHeaderFilter() {
        BearerHeaderFilter filter = new BearerHeaderFilter();
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }

    @Bean
    public HeaderBasedAuthenticationManager authenticationManager() {
        return new HeaderBasedAuthenticationManager();
    }
}
