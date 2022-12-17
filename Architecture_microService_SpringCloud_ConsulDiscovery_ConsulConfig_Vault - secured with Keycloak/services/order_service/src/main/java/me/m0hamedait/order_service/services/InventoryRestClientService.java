package me.m0hamedait.order_service.services;

import me.m0hamedait.order_service.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface InventoryRestClientService {
    @GetMapping("/products?projection=fullProduct")
    public PagedModel<Product> allProducts();
    @GetMapping("/products/{id}?projection=fullProduct")
    public Product productById(@PathVariable Long id);
}
