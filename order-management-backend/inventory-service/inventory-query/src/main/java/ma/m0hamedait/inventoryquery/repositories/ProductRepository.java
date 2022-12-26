package ma.m0hamedait.inventoryquery.repositories;

import ma.m0hamedait.inventoryquery.entities.Category;
import ma.m0hamedait.inventoryquery.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findByCategory(Category category);
}
