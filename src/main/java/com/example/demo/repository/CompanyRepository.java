package com.example.demo.repository;

import com.example.demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    
    // 회사명으로 회사 찾기
    Optional<Company> findByCompanyName(String companyName);
    
    // 업종으로 회사들 찾기
    List<Company> findByIndustry(String industry);
    
    // 설립년도로 회사들 찾기
    List<Company> findByEstablishedYear(Integer establishedYear);
    
    // 직원 수가 특정 수 이상인 회사들 찾기
    List<Company> findByEmployeesCountGreaterThan(Integer employeesCount);
    
    // 회사명이 존재하는지 확인
    boolean existsByCompanyName(String companyName);
    
    // 이메일로 회사 찾기
    Optional<Company> findByEmail(String email);
    
    // 주소에 특정 지역이 포함된 회사들 찾기
    List<Company> findByAddressContaining(String location);
} 