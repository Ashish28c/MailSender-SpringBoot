package com.MailSender.impl;

import java.io.File; 

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {

    private final JavaMailSender mailSender;

    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String subject, String message, String attachment) throws MessagingException {
        JavaMailSenderImpl javaMailSender = (JavaMailSenderImpl) mailSender;
        javaMailSender.setUsername("ashutest288@gmail.com");
        javaMailSender.setPassword("mifpwcdptnurtonb");

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

        messageHelper.setFrom("ashutest288@gmail.com"); // Set the sender email address
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(message);

        // Add attachment
        if (attachment != null && !attachment.isEmpty()) {
            File file = new File(attachment);
            messageHelper.addAttachment(file.getName(), file);
        }

        this.mailSender.send(mimeMessage);
    }
}
