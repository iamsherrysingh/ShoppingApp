package com.sherry.accounts.controller;

import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sherry.accounts.model.Customer;
import com.sherry.accounts.model.Product;
import com.sherry.accounts.model.User;
import com.sherry.accounts.service.CustomerService;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

	@Autowired
	CustomerService customerService;

	@GetMapping("/customers")
	public List<Customer> listCustomers() {
		return customerService.getCustomers();
	}

	@PostMapping("/produce")
	public ResponseEntity<HttpStatus> producer() throws InterruptedException {

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
		props.put("schema.registry.url", "http://localhost:8081");

		Producer<User, Product> producer = new KafkaProducer<>(props);

		User key = new User((new Double(Math.random())).toString(), "Sherry", 120294);
		Product value = new Product(1, "4k IPS 32\" Monitor");
		System.out.println("Kafka Producer ==>" + key + " " + value);
		ProducerRecord<User, Product> record = new ProducerRecord<User, Product>("user-tracking-avro", key, value);
		producer.send(record);

		producer.close();
		return new ResponseEntity<>(HttpStatus.ACCEPTED);

	}

	@PostMapping("/producecustomers")
	public ResponseEntity<HttpStatus> startProducingEvents() throws InterruptedException {

		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

		Producer<String, String> producer = new KafkaProducer<>(props);

		for (Customer customer : customerService.getCustomers()) {
			String key = extractKey(customer);
			String value = extractValue(customer);
			System.out.println("Kafka Producer ==>" + key + " " + value);
			ProducerRecord<String, String> record = new ProducerRecord<String, String>("users", key, value);
			producer.send(record);

		}
		producer.close();
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	private static String extractValue(Customer customer) {
		return customer.getPassword();
	}

	private static String extractKey(Customer customer) {
		return customer.getCustomerName();
	}

	/*
	 * Usage: localhost:8080/accounts/user/Sherry
	 */
	@GetMapping("/customer/{customerName}")
	public Customer getCustomerByCustomerName(@PathVariable String customerName) {
		return customerService.getCustomerByCustomerName(customerName);
	}

	/*
	 * Usage: localhost:8080/accounts/check?userName=Sherry&password=password
	 */
	@GetMapping("/check")
	public boolean checkCustomerNameAndPassword(@RequestParam("customerName") String customerName,
			@RequestParam("password") String password) {
		return customerService.checkCustomerNameAndPassword(customerName, password);
	}

	@PostMapping("/customer")
	public boolean addCustomer(@RequestBody Customer customer) {
		return customerService.addCustomer(customer);

	}

	@DeleteMapping("/customer/{customerName}")
	public boolean deleteCustomer(@PathVariable String customerName) {
		return customerService.deleteCustomer(customerName);
	}

	@PostMapping("/validatePassword")
	public boolean validatePassword(@RequestBody Customer customer) {
		return customerService.validatePassword(customer);
	}
}
