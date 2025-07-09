package com.example.demo.config;

import com.example.demo.model.Company;
import com.example.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private CompanyRepository companyRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // 기존 데이터가 없을 때만 초기 데이터 삽입
        if (companyRepository.count() == 0) {
            loadInitialData();
        }
    }
    
    private void loadInitialData() {
        // 초기 회사 데이터 삽입
        Company company1 = new Company("TechNova Inc.", "Seoul, Gangnam-gu, Teheran-ro 152", 
                                     "02-3456-7890", "info@technova.com", "IT", 2010, 120);
        companyRepository.save(company1);
        
        Company company2 = new Company("GreenEco Co.", "Busan, Haeundae-gu, Marine Rd. 88", 
                                     "051-765-4321", "contact@greeneco.kr", "Renewable Energy", 2015, 75);
        companyRepository.save(company2);
        
        Company company3 = new Company("FinMax Solutions", "Seoul, Yeouido-dong 21", 
                                     "02-9876-5432", "support@finmax.com", "Finance", 2008, 200);
        companyRepository.save(company3);
        
        Company company4 = new Company("AutoNext Corp.", "Incheon, Bupyeong-gu 123", 
                                     "032-345-6789", "sales@autonext.co.kr", "Automobile", 2001, 300);
        companyRepository.save(company4);
        
        Company company5 = new Company("BioHealth Ltd.", "Daejeon, Yuseong-gu, Science Valley 3", 
                                     "042-556-7788", "info@biohealth.kr", "Biotech", 2012, 95);
        companyRepository.save(company5);
        
        Company company6 = new Company("EduLink", "Gwangju, Buk-gu, Innovation Rd. 9", 
                                     "062-333-4444", "hello@edulink.com", "Education", 2017, 40);
        companyRepository.save(company6);
        
        Company company7 = new Company("LogiX Logistics", "Daegu, Seo-gu, Express Rd. 72", 
                                     "053-222-1234", "contact@logix.kr", "Logistics", 2005, 180);
        companyRepository.save(company7);
        
        Company company8 = new Company("BuildCore Ltd.", "Ulsan, Nam-gu, Industrial Rd. 67", 
                                     "052-111-2222", "info@buildcore.com", "Construction", 1999, 320);
        companyRepository.save(company8);
        
        Company company9 = new Company("MediaZone", "Seoul, Mapo-gu, Hongdae 33", 
                                     "02-456-1234", "media@mediazone.kr", "Media", 2018, 60);
        companyRepository.save(company9);
        
        Company company10 = new Company("SoftPilot", "Suwon, Yeongtong-gu, Tech St. 45", 
                                      "031-876-9999", "dev@softpilot.kr", "Software", 2014, 110);
        companyRepository.save(company10);
        
        System.out.println("초기 회사 데이터가 성공적으로 로드되었습니다!");
    }
} 