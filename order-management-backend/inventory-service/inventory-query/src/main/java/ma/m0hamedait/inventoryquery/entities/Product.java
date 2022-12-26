package ma.m0hamedait.inventoryquery.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.m0hamedait.ProductStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private Double price;
    private int quantity;
    private ProductStatus status;
    @ManyToOne
    private Category category;
}
