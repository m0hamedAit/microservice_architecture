package ma.m0hamedait.inventoryquery.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.*;
import ma.m0hamedait.inventoryquery.entities.Category;
import ma.m0hamedait.inventoryquery.repositories.CategoryRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CategoryServiceHandler {
    private CategoryRepository categoryRepository;

    @EventHandler
    public void on(CategoryCreatedEvent event){
        log.info("*** CategoryCreatedEvent received ***");
        Category category = new Category();
        category.setId(event.getId());
        category.setName(event.getName());
        category.setDescription(event.getDescription());
        categoryRepository.save(category);
    }

    @EventHandler
    public void on(CategoryUpdatedEvent event){
        log.info("*** CategoryUpdatedEvent received ***");
        Category category = categoryRepository.findById(event.getId()).get();
        category.setName(event.getName() != null ? event.getName() : category.getName());
        category.setDescription(event.getDescription() != null ? event.getDescription() : category.getDescription());
        categoryRepository.save(category);
    }

    @EventHandler
    public void on(CategoryDeletedEvent event){
        log.info("*** CategoryDeletedEvent received ***");
        categoryRepository.deleteById(event.getId());
    }

    @QueryHandler
    public List<Category> on(GetAllCategoriesQuery query){
        log.info("*** GetAllCategoriesQuery received ***");
        return categoryRepository.findAll();
    }

    @QueryHandler
    public Category on(GetCategoryByIdQuery query){
        log.info("*** GetCategoryByIdQuery received ***");
        return categoryRepository.findById(query.getId()).get();
    }

}
