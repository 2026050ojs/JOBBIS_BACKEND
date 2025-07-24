package com.example.demo.dto;

public class EmailRequest {
    private String email;
    private String resultType;
    private String industries;
    private String description;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getResultType() { return resultType; }
    public void setResultType(String resultType) { this.resultType = resultType; }
    public String getIndustries() { return industries; }
    public void setIndustries(String industries) { this.industries = industries; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
} 