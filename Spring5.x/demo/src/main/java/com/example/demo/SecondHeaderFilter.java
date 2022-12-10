package com.example.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

public class SecondHeaderFilter extends GenericFilterBean {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        HttpServletRequest servletRequest1 = (HttpServletRequest) servletRequest;

        String header = servletRequest1.getHeader(HttpHeaders.AUTHORIZATION);
        String expected = "Basic user:password";
        if (header.equals(expected)) {
            context.setAuthentication(
                    new AnonymousAuthenticationToken(
                            "auth",
                            "client-id",
                            Collections.singleton(new SimpleGrantedAuthority("token"))
                    )
            );
        }
    }
}
