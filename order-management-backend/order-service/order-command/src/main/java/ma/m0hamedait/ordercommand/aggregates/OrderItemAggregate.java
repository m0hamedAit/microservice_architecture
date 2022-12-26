package ma.m0hamedait.ordercommand.aggregates;

import ma.m0hamedait.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class OrderItemAggregate {
     @AggregateIdentifier
     private String id;
     private int quantity;
     private Double unitPrice;
     private int solde;
     private String orderId;
     private String productId;

     public OrderItemAggregate() {
     }

    @CommandHandler
    public OrderItemAggregate(CreateOrderItemCommand command) {
        AggregateLifecycle.apply(new OrderItemCreatedEvent(command.getId(), command.getQuantity(),
                command.getUnitPrice(), command.getSolde(), command.getOrderId(), command.getProductId()));
    }

    @EventSourcingHandler
    public void on(OrderItemCreatedEvent event){
        this.id = event.getId();
        this.quantity = event.getQuantity();
        this.unitPrice = event.getUnitPrice();
        this.solde = event.getSolde();
        this.orderId = event.getOrderId();
        this.productId = event.getProductId();
    }

    @CommandHandler
    public void handle(UpdateOrderItemCommand command){
        AggregateLifecycle.apply(new OrderItemUpdatedEvent(command.getId(), command.getQuantity(),
                command.getUnitPrice(), command.getSolde(), command.getOrderId(), command.getProductId()));
    }

    @EventSourcingHandler
    public void on(OrderItemUpdatedEvent event){
        this.id = event.getId();
        if (event.getQuantity() != 0) {
            this.quantity = event.getQuantity();
        }
        if (event.getUnitPrice() != 0) {
            this.unitPrice = event.getUnitPrice();
        }
        if (event.getSolde() != 0) {
            this.solde = event.getSolde();
        }
        if (event.getOrderId() != null) {
            this.orderId = event.getOrderId();
        }
        if (event.getProductId() != null) {
            this.productId = event.getProductId();
        }
    }

    @CommandHandler
    public void handle(UpdateOrderItemQuantityCommand command){
        AggregateLifecycle.apply(new OrderItemQuantityUpdatedEvent(command.getId(), command.getQuantity()));
    }

    @EventSourcingHandler
    public void on(OrderItemQuantityUpdatedEvent event){
        this.id = event.getId();
        if (event.getQuantity() != 0) {
            this.quantity = event.getQuantity();
        }
    }

    @CommandHandler
    public void handle(DeleteOrderItemCommand command){
        AggregateLifecycle.apply(new OrderItemDeletedEvent(command.getId()));
    }

    @EventSourcingHandler
    public void on(OrderItemDeletedEvent event){
        AggregateLifecycle.markDeleted();
    }

}
