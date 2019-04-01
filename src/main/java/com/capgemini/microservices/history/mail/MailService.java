package com.capgemini.microservices.history.mail;

import com.capgemini.microservices.history.model.MailDTO;

public interface MailService {
	public boolean sendMail(MailDTO mail);	
}
