package com.example.SpringAI_Tutorial.controller;


import com.example.SpringAI_Tutorial.ExceptionHandler;
import com.example.SpringAI_Tutorial.MailSend;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/sendMail")
public class MailController {

    @Autowired
    private MailSend mailSend;

    @GetMapping("/send")
    public String sendEmail() throws MessagingException, TemplateException, IOException {
        String[] mail = {"neeraj.k@decimal.co.in"};
        mailSend.sendMail(mail);
        return "Mail Sent Successfully!";
    }

    @GetMapping("/exception")
    public ResponseEntity<?> exceptionTesting() throws Exception {
        Optional<?> response = mailSend.exceptionMethod();

        if (response.isPresent()) {
            return ResponseEntity.ok(response.get());
        } else {
            return ResponseEntity.ok("No exception occurred!");
        }
    }



}

