package com.capgemini.microservices.payment.services;

import com.capgemini.microservices.payment.model.MailDTO;

public interface ConsumerService {
public void receiver(MailDTO dto);
}
