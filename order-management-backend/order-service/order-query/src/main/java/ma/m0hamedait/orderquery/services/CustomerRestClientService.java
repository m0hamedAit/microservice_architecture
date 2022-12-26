package ma.m0hamedait.orderquery.services;

import ma.m0hamedait.customerquery.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-query-service")
public interface CustomerRestClientService {
    @GetMapping("/queries/customer/{id}")
    public Customer customerInfo(@PathVariable String id);
}
