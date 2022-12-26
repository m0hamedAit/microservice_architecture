package ma.m0hamedait.customercommand.controllers;

import lombok.AllArgsConstructor;
import ma.m0hamedait.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@RestController
@RequestMapping("/commands/customer")
public class CustomerCommandController {
    public CommandGateway  commandGateway;
    public EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createCustomer(@RequestBody CreateCustomerRequestDTO request) {
        return commandGateway.send(new CreateCustomerCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getAddress(),
                request.getEmail(),
                request.getPhone()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateOwner(@RequestBody UpdateCustomerRequestDTO request) {
        return commandGateway.send(new UpdateCustomerCommand(
                request.getId(),
                request.getName(),
                request.getEmail(),
                request.getPhone(),
                request.getAddress()
        ));
    }

    @DeleteMapping("/delete/{id}")
    public CompletableFuture<String> deleteCustomer(@PathVariable String id) {
        return commandGateway.send(new DeleteCustomerCommand(
                id
        ));
    }
}
