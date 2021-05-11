package com.sherry.frauddetection.model.serde;

import java.nio.charset.Charset;

import org.apache.kafka.common.serialization.Serializer;

import com.google.gson.Gson;
import com.sherry.frauddetection.model.Order;

public class OrderSerializer implements Serializer<Order> {

	private static final Charset CHARSET = Charset.forName("UTF-8");
	static private Gson gson = new Gson();

	@Override
	public byte[] serialize(String topic, Order data) {
		String json = gson.toJson(data);
		return json.getBytes();
	}

}
