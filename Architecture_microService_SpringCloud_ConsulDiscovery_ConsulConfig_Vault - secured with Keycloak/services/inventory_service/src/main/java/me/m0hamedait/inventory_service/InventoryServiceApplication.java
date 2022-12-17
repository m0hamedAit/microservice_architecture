package me.m0hamedait.inventory_service;

import me.m0hamedait.inventory_service.entities.Product;
import me.m0hamedait.inventory_service.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ProductRepository productRepository) {
		return args -> {
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
				productRepository.saveAll(List.of(
						Product.builder()
								.name("Laptop "+i)
								.price(1000+Math.random()*10000)
								.quantity(1+random.nextInt(200)).build()
				));}

			productRepository.findAll().forEach(System.out::println);
		};
	}
}
