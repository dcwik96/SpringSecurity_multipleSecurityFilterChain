package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/securedWithToken")
    public String firstEntpoint() {
        return "OK";
    }

    @GetMapping("/securedWithUser")
    public String userSecuredEndpoint() {
        return "OK";
    }

    @GetMapping("/all")
    public String secondEntpoint() {
        return "OK";
    }
}
