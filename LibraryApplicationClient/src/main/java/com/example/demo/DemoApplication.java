package com.example.demo;

import com.example.demo.Domain.Borrow;
import com.example.demo.Domain.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	RestTemplate restTemplate=new RestTemplate();

	private String serverUrl= "http://localhost:8085/customers";


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
          //get all customers
		Customer customerList = restTemplate.getForObject(serverUrl, Customer.class);
		System.out.println("******************* Get all books *******************");
		System.out.println(customerList);

		// get customer from customernumber

		// Get customer by customer number
		Customer customer = restTemplate.getForObject(serverUrl + "/{customerNumber}", Customer.class, "EA001");
		System.out.println("******************* Get customer by customer number *******************");
		System.out.println(customer);

		Borrow borrow=new Borrow();
		// checkout Book
		var checkoutresponse = restTemplate.postForLocation(serverUrl + "/checkout-book", borrow);
		System.out.println(checkoutresponse);

		// return Book
		var returnresponse= restTemplate.postForLocation(serverUrl + "/return-book", borrow);
		System.out.println(returnresponse);


	}
}
