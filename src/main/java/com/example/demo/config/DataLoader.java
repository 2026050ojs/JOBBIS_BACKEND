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
        // 한글 이름, 업종, 주소 등으로 100개 기업 생성
        String[] industries = {"IT", "금융", "자동차", "바이오", "교육", "물류", "건설", "미디어", "소프트웨어", "에너지"};
        String[] industryNames = {"IT", "금융", "자동차", "바이오", "교육", "물류", "건설", "미디어", "소프트웨어", "에너지"};
        String[] city = {"서울", "부산", "대구", "인천", "광주", "대전", "울산", "수원", "성남", "고양"};
        for (int i = 1; i <= 100; i++) {
            int idx = (i - 1) % industries.length;
            int cityIdx = (i - 1) % city.length;
            String name = city[cityIdx] + " " + industries[idx] + "기업" + i;
            String address = city[cityIdx] + "시 중심로 " + (100 + i) + "번길";
            String phone = String.format("0%d-%04d-%04d", (2 + cityIdx), 1000 + i, 2000 + i);
            String email = "contact" + i + "@" + industries[idx].toLowerCase() + ".co.kr";
            String industry = industryNames[idx];
            int year = 1990 + (i % 30);
            int employees = 20 + (i * 3) % 500;
            Company company = new Company(name, address, phone, email, industry, year, employees);
            companyRepository.save(company);
        }
        System.out.println("한글 기업 100개가 성공적으로 로드되었습니다!");
    }
} 