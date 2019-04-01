package com.capgemini.microservices.admin.services;

import com.capgemini.microservices.admin.model.MailDTO;

public interface ProducerService {
public void sender(MailDTO dto);
}
