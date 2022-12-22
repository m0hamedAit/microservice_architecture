## Event Driven Architecture CQRS and Event Sourcing

#### Account :
###### Dependencies
```xml
Spring Web
Spring Data JPA
MySQL Driver
lombok
AXON Framework for spring boot (with axon-server-connector exclusion if we don't want to use axon server)

-- Dependencies for microservices (Consul Discovery, Consul Config, ...)
**make sure to use Java8 and Spring Boot 2.5.2, other ways you may face some issues**
```

DB :
 - Contient plusieurs tables car la persistence de event store est gérée par Axon

----Write------

1 : 
  - We have to create a command handler in the aggregate to handle the command (aggregate is the entity that will handle the command)

@TargetAggregateIdentifier is used to tell Axon that this variable (that has the annotation) is the identifier of the aggregate that will handle the command (which has @AggregateIdentifier annotation)

@CommandHandler is used to tell Axon that this method is a command handler (which has @CommandHandler annotation) it keeps listening to the command and when it receives it, it will execute the method.

A CommandHandler is a decision function that takes a command as input and returns a list of events as output. The events are then applied to the aggregate to update its state.

@EventSourcingHandler : 

EventSourcingHandler is an evolution function 

2 : 
  -after creating the command handler, and the event sourcing handler, we can create an account   ?!

3: 
  - **domain_event_entry** table is the event store, it contains all the events

4: This method "eventStore" shows the event store content for a specific account
5: after adding AccountActivatedEvent, we can see that the event store contains 2 events (AccountCreatedEvent and AccountActivatedEvent)

7-8: after adding creaditAccountCommand and CreditAccountEvent and their handlers, we can see that the event store contains 3 events (AccountCreatedEvent, AccountActivatedEvent and CreditAccountEvent)
9-10: after adding debitAccountCommand and DebitAccountEvent and their handlers, we can see that the event store contains 4 events (AccountCreatedEvent, AccountActivatedEvent, CreditAccountEvent and DebitAccountEvent)

11 - 16 : after adding AccountServiceHandlers for Debit and Credit, we can see that the operation can be now saved, and account balance is updated

17-18: after adding queries and queries handlers, we can now recuperate the account balance and the account history


----Read------
1:05:08