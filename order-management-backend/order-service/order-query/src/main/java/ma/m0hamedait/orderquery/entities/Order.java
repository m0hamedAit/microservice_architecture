package ma.m0hamedait.orderquery.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.m0hamedait.OrderStatus;
import ma.m0hamedait.customerquery.entities.Customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private String id;
    private Date dateOrder;
    private Date dateDelivery;
    private String address;
    private OrderStatus orderStatus;
    @ManyToOne
    private Customer customer;
    @OneToMany(mappedBy = "order")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<OrderItem> orderItems;
}
