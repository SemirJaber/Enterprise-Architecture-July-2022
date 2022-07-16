package com.example.demo;

import com.example.demo.DTOs.CustomerDTO;
import com.example.demo.Domain.Borrow;
import com.example.demo.Domain.Customer;
import com.example.demo.Domain.Payment;
import com.example.demo.Services.CustomerService;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

@Autowired
  private CustomerRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Customer c=new Customer(1, "semir", "semate833@gmail.com",0);
        Borrow b=new Borrow(LocalDate.now(), LocalDate.now());
		Payment p=new Payment(0);
		c.setBorrow(b);
		c.setPayment(p);
		repo.save(c);


	}
}
