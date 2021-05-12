package com.sherry.frauddetection.model.serde;

import org.apache.kafka.common.serialization.Deserializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sherry.frauddetection.model.Order;
import com.sherry.frauddetection.model.gson.OrderAdapter;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class OrderDeserializer implements Deserializer<Order> {

	private static GsonBuilder builder= new GsonBuilder();
	private static Gson gson;

	@Override
	public Order deserialize(String topic, byte[] data) {
		builder.registerTypeAdapter(Order.class, new OrderAdapter());
		gson= builder.create();
		try {

			String order = new String(data);
//			log.info("SERIALIZED STRING: " + order);
			return gson.fromJson(order, Order.class);
		} catch (Exception e) {
			throw new IllegalArgumentException("Error reading bytes", e);
		}
	}

}
