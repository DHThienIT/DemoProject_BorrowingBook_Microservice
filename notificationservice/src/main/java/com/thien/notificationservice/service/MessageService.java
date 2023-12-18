package com.thien.notificationservice.service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.thien.notificationservice.model.MessageDTO;

@Service
public class MessageService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@KafkaListener(id = "notificationGrop", topics = "notification")
	public void listen(MessageDTO messageDTO) {
		System.out.println("============ Received");
		logger.info("=>> " + messageDTO.getToName());
		logger.info("=>> " + messageDTO.getSubject());
		logger.info("=>> " + messageDTO.getContent());
		System.out.println("============");
	}
}
