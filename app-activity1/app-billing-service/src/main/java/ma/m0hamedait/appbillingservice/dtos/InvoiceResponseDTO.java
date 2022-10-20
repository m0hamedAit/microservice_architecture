package ma.m0hamedait.appbillingservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.m0hamedait.appbillingservice.entities.Customer;

import java.math.BigDecimal;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor
public class InvoiceResponseDTO {
    private String id;
    private Date date;
    private BigDecimal amount;
    private Customer customer;
}
