package ma.m0hamedait.customercommand.aggregates;

import ma.m0hamedait.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CustomerAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;

    public CustomerAggregate() {
    }


    @CommandHandler
    public CustomerAggregate(CreateCustomerCommand command) {
        AggregateLifecycle.apply(new CustomerCreatedEvent(command.getId(), command.getName(),
                command.getEmail(), command.getPhone(), command.getAddress()));
    }

    @EventSourcingHandler
    public void on(CustomerCreatedEvent event){
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.phone = event.getPhone();
        this.address = event.getAddress();
    }

    @CommandHandler
    public void handle(UpdateCustomerCommand command){
        AggregateLifecycle.apply(new CustomerUpdatedEvent(command.getId(), command.getName(),
                command.getEmail(), command.getPhone(), command.getAddress()));
    }

    @EventSourcingHandler
    public void on(CustomerUpdatedEvent event){
        this.id = event.getId();
        this.name = event.getName();
        this.email = event.getEmail();
        this.phone = event.getPhone();
        this.address = event.getAddress();
    }

    @CommandHandler
    public void handle(DeleteCustomerCommand command){
        AggregateLifecycle.apply(new CustomerDeletedEvent(command.getId()));
    }

    @EventSourcingHandler
    public void on(CustomerDeletedEvent event){
        AggregateLifecycle.markDeleted();
    }
}


