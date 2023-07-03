package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/health")
    public String checkHealth() {
        return "API is running!";
    }

    @PostMapping("/data")
    public String echoData(@RequestBody String requestBody) {
        return requestBody;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/user")
    public String getUsername() {
        String username = System.getenv("API_USERNAME");
        if (username != null) {
            return username;
        } else {
            return "API_USERNAME environment variable is not set.";
        }
    }
}