package ma.m0hamedait.inventorycommand.controllers;

import lombok.AllArgsConstructor;
import ma.m0hamedait.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@RestController
@RequestMapping("/commands/product")
public class ProductCommandController {
    public CommandGateway commandGateway;
    public EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createProduct(@RequestBody CreateProductRequestDTO request) {
        return commandGateway.send(new CreateProductCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getPrice(),
                request.getQuantity(),
                request.getStatus(),
                request.getCategoryId()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateProduct(@RequestBody UpdateProductRequestDTO request) {
        return commandGateway.send(new UpdateProductCommand(
                request.getId(),
                request.getName(),
                request.getPrice(),
                request.getQuantity(),
                request.getStatus(),
                request.getCategoryId()
        ));
    }

    @PutMapping("/update/quantity")
    public CompletableFuture<String> updateProductQuantity(@RequestBody UpdateProductQuantityRequestDTO request) {
        return commandGateway.send(new UpdateProductQuantityCommand(
                request.getId(),
                request.getQuantity()
        ));
    }

    @PutMapping("/update/status")
    public CompletableFuture<String> updateProductStatus(@RequestBody UpdateProductStatusRequestDTO request) {
        return commandGateway.send(new UpdateProductStatusCommand(
                request.getId(),
                request.getStatus()
        ));
    }

    @DeleteMapping("/delete/{id}")
    public CompletableFuture<String> deleteProduct(@PathVariable String id) {
        return commandGateway.send(new DeleteProductCommand(
                id
        ));
    }
}
