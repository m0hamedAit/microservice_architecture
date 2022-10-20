package ma.m0hamedait.appbillingservice.openFeign;

import ma.m0hamedait.appbillingservice.dtos.InvoiceRequestDTO;
import ma.m0hamedait.appbillingservice.dtos.InvoiceResponseDTO;
import ma.m0hamedait.appbillingservice.entities.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="CUSTOMER-SERVICE")   // c'est ce qu'on a specifier dans "application.properties" pour app-customer-service
public interface CustomerServiceRestClient {
    @GetMapping(path="/api/v1/customers/{id}")
    Customer customerById(@PathVariable String id);

    @GetMapping(path="/api/v1/customers")
    List<Customer> allCustomers();


}
