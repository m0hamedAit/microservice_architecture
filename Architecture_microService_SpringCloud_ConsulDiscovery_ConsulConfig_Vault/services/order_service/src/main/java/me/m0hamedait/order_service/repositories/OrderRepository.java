package me.m0hamedait.order_service.repositories;

import me.m0hamedait.order_service.entities.Order;
import me.m0hamedait.order_service.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, Long> {

}
