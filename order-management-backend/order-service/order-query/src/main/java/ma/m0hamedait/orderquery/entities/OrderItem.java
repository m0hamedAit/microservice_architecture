package ma.m0hamedait.orderquery.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.m0hamedait.inventoryquery.entities.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    private String id;
    private int quantity;
    private double unitPrice;
    private int solde;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Order order;
}
