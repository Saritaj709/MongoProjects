package com.capgemini.microservices.payment.mail;

import com.capgemini.microservices.payment.model.MailDTO;

public interface MailService {
	public boolean sendMail(MailDTO mail);	
}
