package com.MailSender.impl;

import jakarta.mail.MessagingException;

public interface EmailSenderService {
	void sendEmail(String to, String subject, String message,String attachment) throws MessagingException;
}
