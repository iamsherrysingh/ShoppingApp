package com.sherry.frauddetection;

import com.google.gson.Gson;
import com.sherry.frauddetection.model.Order;

public class Playground {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order order = new Order("id", 14, 786f);
		System.out.println(order);

		String jsonString = new Gson().toJson(order);
		System.out.println(jsonString);

		byte[] binary = jsonString.getBytes();
		System.out.println(binary);

		jsonString = new String(binary);
		System.out.println(jsonString);

		Gson gson = new Gson();
		order = gson.fromJson(jsonString, Order.class);
		System.out.println(order);

	}

}
