package com.capgemini.microservices.history.services;

import com.capgemini.microservices.history.model.MailDTO;

public interface ProducerService {
public void sender(MailDTO dto);
}
