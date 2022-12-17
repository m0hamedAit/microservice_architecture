package me.m0hamedait.customer_service;

import me.m0hamedait.customer_service.entities.Customer;
import me.m0hamedait.customer_service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.saveAll(List.of(
					Customer.builder().name("Mohamed").email("mohamed@gmail.com").build(),
					Customer.builder().name("Ahmed").email("ahmed@gmail.com").build(),
					Customer.builder().name("Meriam").email("meriam@gmail.com").build()
			));
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
