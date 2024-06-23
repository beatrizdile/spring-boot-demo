package com.example.demo.welcome;

import org.springframework.stereotype.Component;

@Component
public class Welcome {
    public String getMessage() {
        return "Hello Spring Boot!";
    }
}
