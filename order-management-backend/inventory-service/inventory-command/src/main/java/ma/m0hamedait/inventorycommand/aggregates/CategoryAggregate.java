package ma.m0hamedait.inventorycommand.aggregates;

import ma.m0hamedait.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CategoryAggregate {
     @AggregateIdentifier
     private String id;
     private String name;
     private String description;

     public CategoryAggregate() {
     }

    @CommandHandler
    public CategoryAggregate(CreateCategoryCommand command) {
        AggregateLifecycle.apply(new CategoryCreatedEvent(command.getId(), command.getName(),
                command.getDescription()));
    }

    @EventSourcingHandler
    public void on(CategoryCreatedEvent event){
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
    }

     @CommandHandler
     public void handle(UpdateCategoryCommand command){
            AggregateLifecycle.apply(new CategoryUpdatedEvent(command.getId(), command.getName(),
                    command.getDescription()));
     }

     @EventSourcingHandler
     public void on(CategoryUpdatedEvent event){
            this.id = event.getId();
            this.name = event.getName();
            this.description = event.getDescription();
     }

     @CommandHandler
        public void handle(DeleteCategoryCommand command){
            AggregateLifecycle.apply(new CategoryDeletedEvent(command.getId()));
     }

     @EventSourcingHandler
        public void on(CategoryDeletedEvent event){
            AggregateLifecycle.markDeleted();
     }

}
