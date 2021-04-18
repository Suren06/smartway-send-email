package com.smartway.smartwaysendemail;

import com.smartway.smartwaysendemail.serviceImpl.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SmartwaySendEmailApplication {

	@Autowired
	private EmailSenderService emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(SmartwaySendEmailApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail() throws MessagingException {
		emailSenderService.sendEmail("suren.boyilla@gmail.com",
				"This is my email body..",
				"This is my email subject..");

		emailSenderService.sendEmailWithAttachment("suren.boyilla@gmail.com",
				"This is my email body..",
				"This is my email subject..",
				"/Users/Suren/Desktop/Syon.png");


	}

}
