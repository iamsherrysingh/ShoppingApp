package com.sherry.accounts;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.sherry.accounts.model.Product;
import com.sherry.accounts.model.User;

@EnableCaching
@SpringBootApplication
public class AccountsMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountsMicroserviceApplication.class, args);

		// Consumer 1 config
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("group.id", "user-tracking-consumer");
		props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList("users"));

		// Consumer 2 config
		Properties props2 = new Properties();
		props2.put("bootstrap.servers", "localhost:9092");
		props2.put("group.id", "user-tracking-avro-group");
		props2.put("key.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		props2.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
		props2.put("specific.avro.reader", "true");
		props2.put("schema.registry.url", "http://localhost:8081");

		KafkaConsumer<User, Product> consumer2 = new KafkaConsumer<>(props2);
		consumer2.subscribe(Arrays.asList("user-tracking-avro"));

		// Consume Events
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
			ConsumerRecords<User, Product> records2 = consumer2.poll(Duration.ofMillis(100));

			for (ConsumerRecord<String, String> record : records) {
				System.out.println("Kafka Consumer ==>" + record.key() + " " + record.value());
			}
			for (ConsumerRecord<User, Product> record : records2) {
				System.out.println("Kafka Consumer ==>" + record.key() + " " + record.value());
			}
		}
	}
}
