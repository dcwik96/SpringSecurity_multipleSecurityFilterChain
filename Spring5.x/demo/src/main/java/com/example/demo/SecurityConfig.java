package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    @Order(1)
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .mvcMatcher("/all")
//                .authorizeHttpRequests()
//                .anyRequest()
//                .permitAll();
//
//        return httpSecurity.build();
//    }

    @Bean
    @Order(2)
    public SecurityFilterChain securityFilterChain2(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .mvcMatcher("/securedWithToken")
                .addFilter(securityHeadersPreAuthenticatedFilter())
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
        ;

        return httpSecurity.build();
    }

    @Bean
    @Order()
    public SecurityFilterChain securityFilterChain3(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .mvcMatcher("/securedWithUser")
//                .addFilterBefore(new SecondHeaderFilter(), LogoutFilter.class)
                .addFilter(securityHeadersPreAuthenticatedFilter2())
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
        ;

        return httpSecurity.build();
    }

    @Bean
    public InternalHeaderFilter2 securityHeadersPreAuthenticatedFilter2() {
        InternalHeaderFilter2 filter = new InternalHeaderFilter2();
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }


    @Bean
    public InternalHeaderFilter securityHeadersPreAuthenticatedFilter() {
        InternalHeaderFilter filter = new InternalHeaderFilter();
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }

    @Bean
    public HeaderBasedAuthenticationManager authenticationManager() {
        return new HeaderBasedAuthenticationManager();
    }
}
