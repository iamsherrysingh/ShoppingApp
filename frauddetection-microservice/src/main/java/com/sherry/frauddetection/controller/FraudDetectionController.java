package com.sherry.frauddetection.controller;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sherry.frauddetection.model.Order;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;

@RestController
@RequestMapping("/frauddetection")
public class FraudDetectionController {

	@PostMapping("/produce")
	public ResponseEntity<HttpStatus> producer() throws InterruptedException {

		Properties props = new Properties();
//		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "fraud-detection-application");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
//		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class);
		props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

//		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("schema.registry.url", "http://localhost:8081");

		Producer<String, Order> producer = new KafkaProducer<>(props);

		for (int i = 0; i < 5; i++) {
//			Serde<String> transactionId = Serdes.String();

			String transactionId = String.valueOf(i);
			Order order = new Order(transactionId, (int) (Math.random() * Double.valueOf(i)), 1.0f);
			ProducerRecord<String, Order> record = new ProducerRecord<>("payments", transactionId, order);
			producer.send(record);
		}
		producer.close();
		return new ResponseEntity<>(HttpStatus.ACCEPTED);

	}

	@GetMapping("/hello")
	public String msdsad() {
		return "Hello";
	}

	@GetMapping("/accepted202")
	public ResponseEntity<HttpStatus> method1() {
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	@GetMapping("/accepted202")
	public ResponseEntity<HttpStatus> method2() {
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

}