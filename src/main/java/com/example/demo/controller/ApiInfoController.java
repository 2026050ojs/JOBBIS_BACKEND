package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ApiInfoController {

    @GetMapping("/api/info")
    public Map<String, Object> getApiInfo() {
        Map<String, Object> apiInfo = new HashMap<>();
        apiInfo.put("name", "JOBBIS Backend API");
        apiInfo.put("version", "1.0.0");
        apiInfo.put("description", "회사 정보 관리 시스템 백엔드 API");
        apiInfo.put("port", 9910);
        
        Map<String, String> endpoints = new HashMap<>();
        endpoints.put("companies", "/api/companies");
        endpoints.put("users", "/api/users");
        endpoints.put("h2-console", "/h2-console");
        
        apiInfo.put("endpoints", endpoints);
        
        return apiInfo;
    }

    @GetMapping("/")
    public Map<String, String> getRoot() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "JOBBIS Backend API is running!");
        response.put("api_info", "/api/info");
        response.put("companies", "/api/companies");
        response.put("users", "/api/users");
        response.put("h2_console", "/h2-console");
        return response;
    }
} 