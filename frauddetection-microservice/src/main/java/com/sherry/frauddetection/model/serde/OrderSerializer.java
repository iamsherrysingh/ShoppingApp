package com.sherry.frauddetection.model.serde;

import org.apache.kafka.common.serialization.Serializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sherry.frauddetection.model.Order;
import com.sherry.frauddetection.model.gson.OrderAdapter;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class OrderSerializer implements Serializer<Order> {

	private static GsonBuilder builder= new GsonBuilder();
	private static Gson gson;

	@Override
	public byte[] serialize(String topic, Order data) {
		builder.registerTypeAdapter(Order.class, new OrderAdapter());
		gson= builder.create();
		
		String json = gson.toJson(data);
//		log.info("JSONified Order Object: "+json);
		return json.getBytes();
	}

}
