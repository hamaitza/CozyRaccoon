package com.example.tw_movie_rental.service;

import java.io.File;
import java.io.IOException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.example.tw_movie_rental.Model.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail(String to, String subject, String body) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);

            FileSystemResource file = new FileSystemResource(new File("C:\\Users\\mihai\\Desktop\\fisie.pdf"));
            helper.addAttachment("C:\\Users\\mihai\\Desktop\\fisie.pdf", file);

            mailSender.send(message);
            return "da";
        } catch (Exception e) {
            return e.toString();
        }
    }
}