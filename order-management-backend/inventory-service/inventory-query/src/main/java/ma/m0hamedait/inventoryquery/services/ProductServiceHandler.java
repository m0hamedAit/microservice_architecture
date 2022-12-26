package ma.m0hamedait.inventoryquery.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.*;
import ma.m0hamedait.inventoryquery.entities.Product;
import ma.m0hamedait.inventoryquery.repositories.CategoryRepository;
import ma.m0hamedait.inventoryquery.repositories.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceHandler {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @EventHandler
    public void on(ProductCreatedEvent event){
        log.info("*** ProductCreatedEvent received ***");
        Product product = new Product();
        product.setId(event.getId());
        product.setName(event.getName());
        product.setPrice(event.getPrice());
        product.setQuantity(event.getQuantity());
        product.setStatus(event.getStatus());
        product.setCategory(categoryRepository.findById(event.getCategoryId()).get());
        productRepository.save(product);
    }

    @EventHandler
    public void on(ProductUpdatedEvent event){
        log.info("*** ProductUpdatedEvent received ***");
        Product product = productRepository.findById(event.getId()).get();
        product.setName(event.getName() != null ? event.getName() : product.getName());
        product.setName(event.getName() != null ? event.getName() : product.getName());
        product.setPrice(event.getPrice() != 0 ? event.getPrice() : product.getPrice());
        product.setQuantity(event.getQuantity() != 0 ? event.getQuantity() : product.getQuantity());
        product.setStatus(event.getStatus() != null ? event.getStatus() : product.getStatus());
        product.setCategory(event.getCategoryId() != null ? categoryRepository.findById(event.getCategoryId()).get() : product.getCategory());
        productRepository.save(product);
    }

    @QueryHandler
    public List<Product> on(GetAllProductsQuery query){
        log.info("*** GetAllProductsQuery received ***");
        return productRepository.findAll();
    }

    @QueryHandler
    public Product on(GetProductByIdQuery query){
        log.info("*** GetProductByIdQuery received ***");
        return productRepository.findById(query.getId()).get();
    }

    @QueryHandler
    public List<Product> on(GetProductsByCategoryQuery query){
        log.info("*** GetProductsByCategoryQuery received ***");
        return productRepository.findByCategory(categoryRepository.findById(query.getCategoryId()).get());
    }

}
