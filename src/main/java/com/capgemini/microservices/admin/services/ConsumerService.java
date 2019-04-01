package com.capgemini.microservices.admin.services;

import com.capgemini.microservices.admin.model.MailDTO;

public interface ConsumerService {
public void receiver(MailDTO dto);
}
