package ma.m0hamedait.orderquery.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.*;
import ma.m0hamedait.customerquery.repositories.CustomerRepository;
import ma.m0hamedait.inventoryquery.entities.Category;
import ma.m0hamedait.inventoryquery.repositories.CategoryRepository;
import ma.m0hamedait.orderquery.entities.Order;
import ma.m0hamedait.orderquery.repositories.OrderRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import javax.jws.HandlerChain;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceHandler {
    private OrderRepository orderRepository;

    @EventHandler
    public void on(OrderCreatedEvent event) {
        log.info("*** OrderCreatedEvent received ***");
        Order order = new Order();
        order.setId(event.getId());
        order.setDateDelivery(event.getDateDelivery());
        order.setAddress(event.getAddress());
        order.setOrderStatus(event.getOrderStatus());
        order.setOrderStatus(event.getOrderStatus());
        orderRepository.save(order);
    }


}
