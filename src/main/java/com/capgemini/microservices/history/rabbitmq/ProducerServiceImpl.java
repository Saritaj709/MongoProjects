package com.capgemini.microservices.history.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.capgemini.microservices.history.model.MailDTO;
import com.capgemini.microservices.history.services.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService{
	
	@Autowired
	private AmqpTemplate rabbitTemplate;
	
	@Value("${bridgelabz.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${bridgelabz.rabbitmq.routingkey}")
	private String routingkey;	
	@Override
	public void sender(MailDTO company) {
		rabbitTemplate.convertAndSend(exchange, routingkey, company);
		//System.out.println("Send msg = " + company);
	    
	}
}