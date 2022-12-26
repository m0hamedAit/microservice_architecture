package ma.m0hamedait.orderquery.model;

import lombok.Data;
import ma.m0hamedait.ProductStatus;

@Data
public class Product {
    private String id;
    private String name;
    private Double price;
    private int quantity;
    private ProductStatus status;
}
