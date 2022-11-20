package me.m0hamedait.order_service.web;

import lombok.AllArgsConstructor;
import me.m0hamedait.order_service.entities.Order;
import me.m0hamedait.order_service.repositories.OrderRepository;
import me.m0hamedait.order_service.repositories.ProductItemRepository;
import me.m0hamedait.order_service.services.CustomerRestClientService;
import me.m0hamedait.order_service.services.InventoryRestClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class OrderRestController {

    private OrderRepository orderRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClientService customerRestClientService;
    private InventoryRestClientService inventoryRestClientService;

    @GetMapping("/fullOrder/{id}")
    public Order getOrder(@PathVariable Long id) {
        Order order = orderRepository.findById(id).get();
        order.setCustomer(customerRestClientService.customerById(order.getCustomerId()));
        order.getProductItems().forEach(pi -> {
            pi.setProduct(inventoryRestClientService.productById(pi.getProductId()));
        });
        return order;
    }
}
