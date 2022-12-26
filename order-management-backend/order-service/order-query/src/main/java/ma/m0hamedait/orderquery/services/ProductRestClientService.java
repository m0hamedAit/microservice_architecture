package ma.m0hamedait.orderquery.services;

import ma.m0hamedait.orderquery.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-query-service")
public interface ProductRestClientService {
    @GetMapping("/queries/product/{id}")
    public Product productInfo(@PathVariable String id);
}
