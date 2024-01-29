package com.MailSender.resource;

import lombok.AllArgsConstructor; 
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class emailMessage {
	
	private String to;
	private String subject;
	private String message;
	private String attachment;
	
	
	

}
