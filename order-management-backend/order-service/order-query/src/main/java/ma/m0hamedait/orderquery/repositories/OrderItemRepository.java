package ma.m0hamedait.orderquery.repositories;

import ma.m0hamedait.orderquery.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<Order, String> {
}
