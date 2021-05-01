package com.sherry.product.service;

import java.io.IOException;

public interface ConsumerService {
	public void consume(String message)throws IOException;
}
