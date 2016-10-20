package com.dulccisima.inventario.business;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.dulccisima.inventario.model.EmailMessage;

public class EmailBusiness {

	private static final String USERNAME = "dulccisima.canete@gmail.com";
	private static final String PASSWORD = "fesaqwerasdf";
	private Properties mailProperties;

	public EmailBusiness() {
		mailProperties = new Properties();
		mailProperties.setProperty("mail.smtp.host", "smtp.gmail.com");
		mailProperties.setProperty("mail.smtp.starttls.enable", "true");
		mailProperties.setProperty("mail.smtp.port", "587");
		mailProperties.setProperty("mail.smtp.auth", "true");
		mailProperties.setProperty("mail.transport.protocol", "smtp");
	}

	public boolean sendEmail(EmailMessage emailMessage) {
		Transport transport = null;
		try {
			Session session = Session.getDefaultInstance(mailProperties);

			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(emailMessage.getFrom()));
			message.setSubject(emailMessage.getSubject());
			message.setText(emailMessage.getText());

			if (emailMessage.getToList() != null) {
				for (String to : emailMessage.getToList()) {
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				}
			}
			if (emailMessage.getCcList() != null) {
				for (String cc : emailMessage.getCcList()) {
					message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
				}
			}
			if (emailMessage.getBccList() != null) {
				for (String bcc : emailMessage.getBccList()) {
					message.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
				}
			}
			transport = session.getTransport();
			transport.connect(USERNAME, PASSWORD);
			transport.sendMessage(message, message.getAllRecipients());
			return true;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (transport != null) {
					transport.close();
				}
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
	}

}
