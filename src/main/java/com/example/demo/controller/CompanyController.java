package com.example.demo.controller;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {
    
    @Autowired
    private CompanyRepository companyRepository;
    
    // 모든 회사 조회
    @GetMapping
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
    
    // ID로 회사 조회
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Integer id) {
        Optional<Company> company = companyRepository.findById(id);
        return company.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    // 회사명으로 회사 조회
    @GetMapping("/name/{companyName}")
    public ResponseEntity<Company> getCompanyByName(@PathVariable String companyName) {
        Optional<Company> company = companyRepository.findByCompanyName(companyName);
        return company.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }
    
    // 업종으로 회사들 조회
    @GetMapping("/industry/{industry}")
    public List<Company> getCompaniesByIndustry(@PathVariable String industry) {
        return companyRepository.findByIndustry(industry);
    }
    
    // 직원 수가 특정 수 이상인 회사들 조회
    @GetMapping("/employees/{minEmployees}")
    public List<Company> getCompaniesByMinEmployees(@PathVariable Integer minEmployees) {
        return companyRepository.findByEmployeesCountGreaterThan(minEmployees);
    }
    
    // 새 회사 생성
    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyRepository.save(company);
    }
    
    // 회사 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Integer id, @RequestBody Company companyDetails) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            Company updatedCompany = company.get();
            updatedCompany.setCompanyName(companyDetails.getCompanyName());
            updatedCompany.setAddress(companyDetails.getAddress());
            updatedCompany.setPhone(companyDetails.getPhone());
            updatedCompany.setEmail(companyDetails.getEmail());
            updatedCompany.setIndustry(companyDetails.getIndustry());
            updatedCompany.setEstablishedYear(companyDetails.getEstablishedYear());
            updatedCompany.setEmployeesCount(companyDetails.getEmployeesCount());
            return ResponseEntity.ok(companyRepository.save(updatedCompany));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // 회사 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCompany(@PathVariable Integer id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isPresent()) {
            companyRepository.delete(company.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 