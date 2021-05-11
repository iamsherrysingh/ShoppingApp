package com.sherry.frauddetection.model.serde;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

import com.sherry.frauddetection.model.Order;

public class OrderSerde implements Serde<Order> {
	Serializer<Order> serializer = new OrderSerializer();
	Deserializer<Order> deserializer = new OrderDeserializer();

	@Override
	public Serializer<Order> serializer() {
		return serializer;
	}

	@Override
	public Deserializer<Order> deserializer() {
		return deserializer;
	}

}
