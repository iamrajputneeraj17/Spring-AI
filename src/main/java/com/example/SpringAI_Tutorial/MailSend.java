package com.example.SpringAI_Tutorial;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class MailSend {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration freemarkerConfiguration;

    public void sendMail(String[] emails) throws MessagingException, IOException, TemplateException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(emails);
        helper.setSubject("Please Pay Attention!");
        helper.addAttachment("Indus_accountLogin", new File("C:\\Users\\Neeraj Kumar\\Downloads\\Indus_accountLogin.png"));

        Map<String, Object> model = new HashMap<>();
        model.put("subject", "Welcome to Our Service!");
        model.put("headerText", "Welcome to Our Platform");
        model.put("name", "Neeraj Singh Rajput");
        model.put("bodyMessage", "Your account has been successfully created. Please verify your email by clicking the button below.");
        model.put("actionUrl", "https://example.com/verify-email");
        model.put("companyName", "MyCompany");
        model.put("year", Year.now().toString()); // import java.time.Year;

        Template template = freemarkerConfiguration.getTemplate("testingFTL.ftl");
        String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
        helper.setText(htmlContent, true);
        mailSender.send(message);

    }

    public Optional<?> exceptionMethod() throws Exception {
            int b = 10 / 0;
            throw new Exception("Not Found");

    }


    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ExceptionHandler exceptionHandler(Exception e)
    {
        ExceptionHandler handler = new ExceptionHandler(LocalDateTime.now(), e.getMessage(), "Something Went wrong!");
        return handler;
    }
}

