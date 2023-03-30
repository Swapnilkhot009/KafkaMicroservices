package com.kafkaConsumer2.EmailService.Kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.Basedomains.DTO.OrderEvent;

@Service
public class OrderConsumer {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);
	
	/* This method will use kafkaListener annotation to listen/
	 * subscribe the provided topic and our OrderConsumer class will
	 * be a consumer that belongs to given groupId (stock)*/
	@KafkaListener(topics = "${spring.kafka.topic.name}",
				   groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent event) {
		LOGGER.info(String.format("Order event received in email service => %s", event.toString()));
		/*Once he this service receives a event it can send email to customer
		 * here just we log*/
		
	}
}
