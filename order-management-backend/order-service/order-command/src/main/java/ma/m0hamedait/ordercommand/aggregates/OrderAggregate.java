package ma.m0hamedait.ordercommand.aggregates;

import ma.m0hamedait.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
public class OrderAggregate {
     @AggregateIdentifier
     private String id;
     private Date dateOrder;
     private Date dateDelivery;
     private String address;
     private OrderStatus orderStatus;
     private String customerId;

     public OrderAggregate() {
     }

    @CommandHandler
    public OrderAggregate(CreateOrderCommand command) {
        AggregateLifecycle.apply(new OrderCreatedEvent(command.getId(), command.getDateOrder(),
                command.getDateDelivery(), command.getAddress(), command.getOrderStatus(), command.getCustomerId()));
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event){
        this.id = event.getId();
        this.dateOrder = event.getDateOrder();
        this.dateDelivery = event.getDateDelivery();
        this.address = event.getAddress();
        this.orderStatus = event.getOrderStatus();
        this.customerId = event.getCustomerId();
    }

    @CommandHandler
    public void handle(UpdateOrderCommand command){
        AggregateLifecycle.apply(new OrderUpdatedEvent(command.getId(), command.getDateOrder(),
                command.getDateDelivery(), command.getAddress(), command.getOrderStatus(), command.getCustomerId()));
    }

    @EventSourcingHandler
    public void on(OrderUpdatedEvent event){
        this.id = event.getId();
        if (event.getDateOrder() != null) {
            this.dateOrder = event.getDateOrder();
        }
        if (event.getDateDelivery() != null) {
            this.dateDelivery = event.getDateDelivery();
        }
        if (event.getAddress() != null) {
            this.address = event.getAddress();
        }
        if (event.getOrderStatus() != null) {
            this.orderStatus = event.getOrderStatus();
        }
        if (event.getCustomerId() != null) {
            this.customerId = event.getCustomerId();
        }
    }

     @CommandHandler
    public void handle(UpdateOrderStatusCommand command){
        AggregateLifecycle.apply(new OrderStatusUpdatedEvent(command.getId(), command.getOrderStatus()));
    }

    @EventSourcingHandler
    public void on(OrderStatusUpdatedEvent event){
        this.id = event.getId();
        if (event.getOrderStatus() != null) {
            this.orderStatus = event.getOrderStatus();
        }
    }

    @CommandHandler
    public void handle(DeleteOrderCommand command){
        AggregateLifecycle.apply(new OrderDeletedEvent(command.getId()));
    }

    @EventSourcingHandler
    public void on(OrderDeletedEvent event){
        AggregateLifecycle.markDeleted();
    }


}
