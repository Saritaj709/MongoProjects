package com.capgemini.microservices.history.services;

import com.capgemini.microservices.history.model.MailDTO;

public interface ConsumerService {
public void receiver(MailDTO dto);
}
