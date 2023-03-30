package com.kafkaProducer.OrderService.Controllers;

import org.apache.kafka.common.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.Basedomains.DTO.Order;
import com.kafka.Basedomains.DTO.OrderEvent;
import com.kafkaProducer.OrderService.Kafka.OrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	@Autowired
	private OrderProducer orderProducer;
	
	@PostMapping("/orders")
	public String placeOrder(@RequestBody Order order) {
		order.setOrderId(Uuid.randomUuid().toString());
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setStatus("pending");
		orderEvent.setMessage("Order in in pending state");
		orderEvent.setOrder(order);
		orderProducer.sendMessage(orderEvent);
		return "Order PlacedSucceddfully to kafka server";
	}
}
