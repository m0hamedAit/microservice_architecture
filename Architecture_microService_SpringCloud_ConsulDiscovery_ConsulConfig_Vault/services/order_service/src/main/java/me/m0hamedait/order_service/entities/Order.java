package me.m0hamedait.order_service.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.m0hamedait.order_service.enums.OrderStatus;
import me.m0hamedait.order_service.model.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private OrderStatus status;
    private Long customerId;
    @Transient // to ignore this field in the database
    private Customer customer;
    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;
}
