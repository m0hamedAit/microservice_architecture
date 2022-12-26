package ma.m0hamedait.inventoryquery.repositories;

import ma.m0hamedait.inventoryquery.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
