package com.capgemini.microservices.payment.services;

import com.capgemini.microservices.payment.model.MailDTO;

public interface ProducerService {
public void sender(MailDTO dto);
}
