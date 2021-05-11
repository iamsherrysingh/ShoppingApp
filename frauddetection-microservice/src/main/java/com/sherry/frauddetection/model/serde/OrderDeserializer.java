package com.sherry.frauddetection.model.serde;

import java.nio.charset.Charset;

import org.apache.kafka.common.serialization.Deserializer;

import com.google.gson.Gson;
import com.sherry.frauddetection.model.Order;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class OrderDeserializer implements Deserializer<Order> {

	private static final Charset CHARSET = Charset.forName("UTF-8");
	static private Gson gson = new Gson();

	@Override
	public Order deserialize(String topic, byte[] data) {
		try {
			String order = new String(data);
			log.info("SERIALIZED STRING: " + order);
			return gson.fromJson(order, Order.class);
		} catch (Exception e) {
			throw new IllegalArgumentException("Error reading bytes", e);
		}
	}

}
