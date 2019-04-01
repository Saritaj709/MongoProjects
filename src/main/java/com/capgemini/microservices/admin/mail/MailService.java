package com.capgemini.microservices.admin.mail;

import com.capgemini.microservices.admin.model.MailDTO;

public interface MailService {
	public boolean sendMail(MailDTO mail);	
}
