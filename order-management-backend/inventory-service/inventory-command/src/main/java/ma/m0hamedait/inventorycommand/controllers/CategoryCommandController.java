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
@RequestMapping("/commands/category")
public class CategoryCommandController {
    public CommandGateway commandGateway;
    public EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createCategory(@RequestBody CreateCategoryRequestDTO request) {
        return commandGateway.send(new CreateCategoryCommand(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getDescription()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateCategory(@RequestBody UpdateCategoryRequestDTO request) {
        return commandGateway.send(new UpdateCategoryCommand(
                request.getId(),
                request.getName(),
                request.getDescription()
        ));
    }

    @DeleteMapping("/delete/{id}")
    public CompletableFuture<String> deleteCategory(@PathVariable String id) {
        return commandGateway.send(new DeleteCategoryCommand(
                id
        ));
    }
}
