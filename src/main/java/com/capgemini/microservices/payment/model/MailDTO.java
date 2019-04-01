package com.capgemini.microservices.payment.model;

public class MailDTO {
	private String to;
	private String subject;
	private String text;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "MailDTO [to=" + to + ", subject=" + subject + ", text=" + text + "]";
	}

}
