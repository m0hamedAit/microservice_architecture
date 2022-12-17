package me.m0hamedait.order_service;

import lombok.AllArgsConstructor;
import me.m0hamedait.order_service.entities.Order;
import me.m0hamedait.order_service.entities.ProductItem;
import me.m0hamedait.order_service.enums.OrderStatus;
import me.m0hamedait.order_service.model.Customer;
import me.m0hamedait.order_service.model.Product;
import me.m0hamedait.order_service.repositories.OrderRepository;
import me.m0hamedait.order_service.repositories.ProductItemRepository;
import me.m0hamedait.order_service.services.CustomerRestClientService;
import me.m0hamedait.order_service.services.InventoryRestClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(
			OrderRepository orderRepository,
			ProductItemRepository productItemRepository,
			CustomerRestClientService customerRestClientService,
			InventoryRestClientService inventoryRestClientService
	){
		return args -> {
			List<Customer> customers = customerRestClientService.allCustomers().getContent().stream().toList();
			List<Product> products = inventoryRestClientService.allProducts().getContent().stream().toList();
			Long customerId = 1L;
			Random random = new Random();
			Customer customer = customerRestClientService.customerById(customerId);
			for(int i = 0; i < 25; i++){
				Order order = Order.builder().customerId(customers.get(random.nextInt(customers.size())).getId())
						.status(OrderStatus.values()[random.nextInt(OrderStatus.values().length)])
						.createdAt(new Date()).build();

				Order savedOrder = orderRepository.save(order);

				for(int j = 0; j < products.size(); j++){
					if(Math.random()>0.5){
						ProductItem productItem = ProductItem.builder()
								.productId(products.get(j).getId())
								.order(savedOrder)
								.productName(products.get(j).getName())
								.quantity(1+random.nextInt(10))
								.price(products.get(j).getPrice())
								.discount(Math.random())
								.build();
						productItemRepository.save(productItem);
					}

				}
			}

		};
	}

}
