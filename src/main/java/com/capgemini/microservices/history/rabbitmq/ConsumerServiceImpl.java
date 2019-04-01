package com.capgemini.microservices.history.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.microservices.history.mail.MailService;
import com.capgemini.microservices.history.model.MailDTO;
import com.capgemini.microservices.history.services.ConsumerService;

@Component
public class ConsumerServiceImpl implements ConsumerService {

	@Autowired
	private MailService mailService;

	@Override
	@RabbitListener(queues = "${bridgelabz.rabbitmq.queue}")
	public void receiver(MailDTO msg) {
		mailService.sendMail(msg);
	}
}
