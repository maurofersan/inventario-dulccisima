package com.dulccisima.inventario.model.builder;

import java.util.ArrayList;

import com.dulccisima.inventario.model.EmailMessage;

public class EmailMessageBuilder {

	private EmailMessage emailMessage;

	public EmailMessageBuilder() {
		emailMessage = new EmailMessage();
	}

	public EmailMessageBuilder setFrom(String from) {
		emailMessage.setFrom(from);
		return this;
	}

	public EmailMessageBuilder setSubject(String subject) {
		emailMessage.setSubject(subject);
		return this;
	}

	public EmailMessageBuilder setText(String text) {
		emailMessage.setText(text);
		return this;
	}

	public EmailMessageBuilder addTo(String... emailAddresses) {
		if (emailMessage.getToList() == null) {
			emailMessage.setToList(new ArrayList<String>());
		}
		for (String emailAddress : emailAddresses) {
			emailMessage.getToList().add(emailAddress);
		}
		return this;
	}

	public EmailMessageBuilder addCc(String... emailAddresses) {
		if (emailMessage.getCcList() == null) {
			emailMessage.setCcList(new ArrayList<String>());
		}
		for (String emailAddress : emailAddresses) {
			emailMessage.getCcList().add(emailAddress);
		}
		return this;
	}

	public EmailMessageBuilder addBcc(String... emailAddresses) {
		if (emailMessage.getBccList() == null) {
			emailMessage.setBccList(new ArrayList<String>());
		}
		for (String emailAddress : emailAddresses) {
			emailMessage.getBccList().add(emailAddress);
		}
		return this;
	}

	public EmailMessage build() {
		return emailMessage;
	}

}