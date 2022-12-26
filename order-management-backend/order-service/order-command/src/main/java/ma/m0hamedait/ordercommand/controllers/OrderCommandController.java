package ma.m0hamedait.ordercommand.controllers;

import lombok.AllArgsConstructor;
import ma.m0hamedait.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@AllArgsConstructor
@RestController
@RequestMapping("/commands/order")
public class OrderCommandController {
    public CommandGateway commandGateway;
    public EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createOrder(@RequestBody CreateOrderRequestDTO request) {
        return commandGateway.send(new CreateOrderCommand(
                UUID.randomUUID().toString(),
                new Date(),
                request.getDateDelivery(),
                request.getAddress(),
                request.getOrderStatus(),
                request.getCustomerId()
        ));
    }

    @PutMapping("/update")
    public CompletableFuture<String> updateOrder(@RequestBody UpdateOrderRequestDTO request) {
        return commandGateway.send(new UpdateOrderCommand(
                request.getId(),
                request.getDateOrder(),
                request.getDateDelivery(),
                request.getAddress(),
                request.getOrderStatus(),
                request.getCustomerId()
        ));
    }

    @PutMapping("/updateStatus")
    public CompletableFuture<String> updateOrderStatus(@RequestBody UpdateOrderStatusRequestDTO request) {
        return commandGateway.send(new UpdateOrderStatusCommand(
                request.getId(),
                request.getOrderStatus()
        ));
    }

    @DeleteMapping("/delete")
    public CompletableFuture<String> deleteOrder(@RequestBody DeleteOrderRequestDTO request) {
        return commandGateway.send(new DeleteOrderCommand(
                request.getId()
        ));
    }

    @PostMapping("/orderItem/create")
    public CompletableFuture<String> createOrderItem(@RequestBody CreateOrderItemRequestDTO request) {
        return commandGateway.send(new CreateOrderItemCommand(
                UUID.randomUUID().toString(),
                request.getQuantity(),
                request.getUnitPrice(),
                request.getSolde(),
                request.getOrderId(),
                request.getProductId()
        ));
    }

    @PutMapping("/orderItem/update")
    public CompletableFuture<String> updateOrderItem(@RequestBody UpdateOrderItemRequestDTO request) {
        return commandGateway.send(new UpdateOrderItemCommand(
                request.getId(),
                request.getQuantity(),
                request.getUnitPrice(),
                request.getSolde(),
                request.getOrderId(),
                request.getProductId()
        ));
    }

    @PutMapping("/orderItem/updateQuantity")
    public CompletableFuture<String> updateOrderItemQuantity(@RequestBody UpdateOrderItemQuantityRequestDTO request) {
        return commandGateway.send(new UpdateOrderItemQuantityCommand(
                request.getId(),
                request.getQuantity()
        ));
    }

    @DeleteMapping("/orderItem/delete")
    public CompletableFuture<String> deleteOrderItem(@RequestBody DeleteOrderItemRequestDTO request) {
        return commandGateway.send(new DeleteOrderItemCommand(
                request.getId()
        ));
    }







}
