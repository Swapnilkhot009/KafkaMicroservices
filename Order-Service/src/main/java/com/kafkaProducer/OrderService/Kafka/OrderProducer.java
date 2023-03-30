package com.kafkaProducer.OrderService.Kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.Basedomains.DTO.OrderEvent;

@Service
public class OrderProducer {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);
	
	@Autowired
	private NewTopic topic;
	
	private KafkaTemplate<String , OrderEvent> kafkaTemplate;
	
	/* Add dependancy of base-domains in pom.xml as we need it here */
	public OrderProducer(NewTopic topic, KafkaTemplate<String,OrderEvent> kafkaTemplate) {
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(OrderEvent event) {
		LOGGER.info(String.format("Order event sent to kafka server => %s", event.toString()));
		/*Create Message*/
		Message<OrderEvent> message = MessageBuilder
				.withPayload(event)
				.setHeader(KafkaHeaders.TOPIC, topic.name())
				.build();
		
		/*Send message to kafka server*/
		kafkaTemplate.send(message);
	}
}
