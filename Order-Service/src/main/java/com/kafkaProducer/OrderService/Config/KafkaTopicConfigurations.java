package com.kafkaProducer.OrderService.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfigurations {
	
	@Value("${spring.kafka.topic.name}")
	private String topicName;
	
	/* Spring bean for kafka topic */
	@Bean
	public NewTopic topic() {
		return TopicBuilder.name(topicName)
				.build();
		/* return TopicBuilder.name(topicName)
		        .partitions(3) for partitions
				.build(); */
	}
}
