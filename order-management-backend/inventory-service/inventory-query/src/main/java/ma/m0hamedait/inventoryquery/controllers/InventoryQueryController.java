package ma.m0hamedait.inventoryquery.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.*;
import ma.m0hamedait.inventoryquery.entities.Category;
import ma.m0hamedait.inventoryquery.entities.Product;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queries/inventory")
@AllArgsConstructor
@Slf4j
public class InventoryQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/category/allCategories")
    public List<Category> getAllCategories(){
        return queryGateway.query(new GetAllCategoriesQuery(),
                ResponseTypes.multipleInstancesOf(Category.class)).join();
    }

    @GetMapping("/category/{id}")
    public Category categoryInfo(@PathVariable String id){
        return queryGateway.query(new GetCategoryByIdQuery(id),
                ResponseTypes.instanceOf(Category.class)).join();
    }

    @GetMapping("/product/allProducts")
    public List<Category> getAllProducts(){
        return queryGateway.query(new GetAllProductsQuery(),
                ResponseTypes.multipleInstancesOf(Category.class)).join();
    }

    @GetMapping("/product/{id}")
    public Product productInfo(@PathVariable String id){
        return queryGateway.query(new GetProductByIdQuery(id),
                ResponseTypes.instanceOf(Product.class)).join();
    }

    @GetMapping("/category/{id}/products")
    public List<Product> categoryProducts(@PathVariable String id){
        return queryGateway.query(new GetProductsByCategoryQuery(id),
                ResponseTypes.multipleInstancesOf(Product.class)).join();
    }
}
