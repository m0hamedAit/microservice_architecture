package ma.m0hamedait.inventorycommand.aggregates;

import ma.m0hamedait.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ProductAggregate {
     @AggregateIdentifier
     private String id;
     private String name;
     private Double price;
     private int quantity;
     private ProductStatus status;
     private String categoryId;

     public ProductAggregate() {
     }

    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        AggregateLifecycle.apply(new ProductCreatedEvent(command.getId(), command.getName(),
                command.getPrice(), command.getQuantity(), command.getStatus(), command.getCategoryId()));
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event){
        this.id = event.getId();
        this.name = event.getName();
        this.price = event.getPrice();
        this.quantity = event.getQuantity();
        this.status = event.getStatus();
        this.categoryId = event.getCategoryId();
    }

     @CommandHandler
     public void handle(UpdateProductCommand command){
            AggregateLifecycle.apply(new ProductUpdatedEvent(command.getId(), command.getName(),
                     command.getPrice(), command.getQuantity(), command.getStatus(), command.getCategoryId()));
     }

     @EventSourcingHandler
     public void on(ProductUpdatedEvent event){
            this.id = event.getId();
            this.name = event.getName();
            this.price = event.getPrice();
            this.quantity = event.getQuantity();
            this.status = event.getStatus();
            this.categoryId = event.getCategoryId();
     }

      @CommandHandler
      public void handle(UpdateProductStatusCommand command){
                AggregateLifecycle.apply(new ProductStatusUpdatedEvent(command.getId(), command.getStatus()));
     }

     @EventSourcingHandler
     public void on(ProductStatusUpdatedEvent event){
                this.id = event.getId();
                this.status = event.getStatus();
     }

     @CommandHandler
     public void handle(UpdateProductQuantityCommand command){
                AggregateLifecycle.apply(new ProductQuantityUpdatedEvent(command.getId(), command.getQuantity()));
     }

     @EventSourcingHandler
     public void on(ProductQuantityUpdatedEvent event){
                this.id = event.getId();
                this.quantity = event.getQuantity();
     }

     @CommandHandler
     public void handle(DeleteProductCommand command){
                AggregateLifecycle.apply(new ProductDeletedEvent(command.getId()));
     }

     @EventSourcingHandler
     public void on(ProductDeletedEvent event){
                    AggregateLifecycle.markDeleted();
     }
}
