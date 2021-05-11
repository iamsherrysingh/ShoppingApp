package com.sherry.frauddetection;

import java.util.Properties;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
//import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sherry.frauddetection.model.Order;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class FraudDetectionApplication {
//	private static Logger LOG = LoggerFactory.getLogger(FraudDetectionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FraudDetectionApplication.class, args);

		Properties props = new Properties();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "fraud-detection-application");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class);
		props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");

		StreamsBuilder streamsBuilder = new StreamsBuilder();

		KStream<String, Order> stream = streamsBuilder.stream("payments");
//		stream.peek(FraudDetectionApplication::printOnEnter)
//				.filter((transactionId, order) -> !order.getUserId().toString().equals(""))
//				.filter((transactionId, order) -> order.getNbOfItems() < 1000)
//				.filter((transactionId, order) -> order.getTotalAmount() <= 10000).mapValues((order) -> {
//					order.setUserId(String.valueOf(order.getUserId()).toUpperCase());
//					return order;})
//				.peek(FraudDetectionApplication::printOnExit).to("validated-payments");

		Topology topology = streamsBuilder.build();

		KafkaStreams streams = new KafkaStreams(topology, props);

		streams.start();

		Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
	}

	private static void printOnEnter(String transactionId, Order order) {
		log.info("*******************");
		log.info("Entering stream with Transaction ID" + transactionId);
		log.info("and order: " + order);
	}

	private static void printOnExit(String transactionId, Order order) {
		log.info("*******************");
		log.info("Exiting stream with Transaction ID" + transactionId);
		log.info("and order: " + order);
	}

}
