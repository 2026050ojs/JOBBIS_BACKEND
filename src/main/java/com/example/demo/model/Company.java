package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "companies")
public class Company {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "company_name", nullable = false)
    private String companyName;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "industry")
    private String industry;
    
    @Column(name = "established_year")
    private Integer establishedYear;
    
    @Column(name = "employees_count")
    private Integer employeesCount;
    
    // 기본 생성자
    public Company() {}
    
    // 생성자
    public Company(String companyName, String address, String phone, String email, 
                   String industry, Integer establishedYear, Integer employeesCount) {
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.industry = industry;
        this.establishedYear = establishedYear;
        this.employeesCount = employeesCount;
    }
    
    // Getter와 Setter
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getIndustry() {
        return industry;
    }
    
    public void setIndustry(String industry) {
        this.industry = industry;
    }
    
    public Integer getEstablishedYear() {
        return establishedYear;
    }
    
    public void setEstablishedYear(Integer establishedYear) {
        this.establishedYear = establishedYear;
    }
    
    public Integer getEmployeesCount() {
        return employeesCount;
    }
    
    public void setEmployeesCount(Integer employeesCount) {
        this.employeesCount = employeesCount;
    }
    
    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", industry='" + industry + '\'' +
                ", establishedYear=" + establishedYear +
                ", employeesCount=" + employeesCount +
                '}';
    }
} 