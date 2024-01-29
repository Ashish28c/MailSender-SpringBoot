package com.MailSender.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MailSender.impl.EmailSenderService;
import com.MailSender.resource.emailMessage;

import jakarta.mail.MessagingException;

@RestController
public class EmailController {
	private final EmailSenderService emailSenderService;


    EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }
	
	
    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody emailMessage emailMessage) throws MessagingException {
        String to = emailMessage.getTo();
        String subject = emailMessage.getSubject();
        String message = emailMessage.getMessage();
        String attachment = emailMessage.getAttachment();

        emailSenderService.sendEmail(to, subject, message, attachment);
		return ResponseEntity.ok("Email sent successfully.");
    }
}
