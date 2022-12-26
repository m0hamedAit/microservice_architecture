package ma.m0hamedait.orderquery.model;

import lombok.Data;

@Data
public class Customer {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
