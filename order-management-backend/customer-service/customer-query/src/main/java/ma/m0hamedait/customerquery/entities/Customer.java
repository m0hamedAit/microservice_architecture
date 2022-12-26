package ma.m0hamedait.customerquery.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
}
