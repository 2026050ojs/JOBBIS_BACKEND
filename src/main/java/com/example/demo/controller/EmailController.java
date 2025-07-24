package com.example.demo.controller;

import com.example.demo.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/send-result-email")
    public String sendResultEmail(@RequestBody EmailRequest req) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(req.getEmail());
        message.setSubject("JOBBIS 검사 결과 안내");
        message.setText(
            "안녕하세요!\n\n" +
            "당신의 검사 유형: " + req.getResultType() + "\n" +
            "추천 업종: " + req.getIndustries() + "\n" +
            "설명: " + req.getDescription() + "\n\n" +
            "JOBBIS에서 성공적인 커리어를 응원합니다!"
        );
        mailSender.send(message);
        return "이메일 발송 완료";
    }
} 