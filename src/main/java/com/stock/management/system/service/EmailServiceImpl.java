package com.stock.management.system.service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {

	private static final String EMAIL_HOST = "your-email-host";
	private static final int EMAIL_PORT = 587;
	private static final String EMAIL_USERNAME = "your-email-username";
	private static final String EMAIL_PASSWORD = "your-email-password";

	public void sendEmail(String recipientEmail, String subject, String content) {
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", EMAIL_HOST);
		properties.put("mail.smtp.port", EMAIL_PORT);

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EMAIL_USERNAME));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
			message.setSubject(subject);
			message.setText(content);

			Transport.send(message);

			System.out.println("Email sent successfully!");
		} catch (MessagingException e) {
			System.out.println("Failed to send email: " + e.getMessage());
		}
	}
}
