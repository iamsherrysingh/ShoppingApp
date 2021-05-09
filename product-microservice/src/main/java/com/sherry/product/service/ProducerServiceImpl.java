package com.sherry.product.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {

	private static final Logger logger = LoggerFactory.getLogger(ProducerServiceImpl.class);
	private static final String TOPIC = "users";

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		logger.info(String.format("#### -> Producing message -> %s", message));
		for (int i = 0; i < 1000000000; i++) {
			this.kafkaTemplate.send(TOPIC, message);
		}

	}
}