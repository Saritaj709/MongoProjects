package com.capgemini.microservices.admin.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.microservices.admin.mail.MailService;
import com.capgemini.microservices.admin.model.MailDTO;
import com.capgemini.microservices.admin.services.ConsumerService;

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
