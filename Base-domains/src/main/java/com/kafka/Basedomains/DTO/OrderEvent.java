package com.kafka.Basedomains.DTO;

import javax.print.event.PrintJobAttributeEvent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEvent {
	private String message;
	private String status;
	private Order order;
}
