package ma.m0hamedait.appbillingservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.m0hamedait.appbillingservice.entities.Customer;

import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class InvoiceRequestDTO {
    private BigDecimal amount;
    private String customerID;

}
