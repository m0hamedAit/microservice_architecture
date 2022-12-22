package ma.m0hamedait.accountcqrses.commands.controllers;

import lombok.AllArgsConstructor;
import ma.m0hamedait.accountcqrses.commonAPI.commands.CreateAccountCommand;
import ma.m0hamedait.accountcqrses.commonAPI.commands.CreditAccountCommand;
import ma.m0hamedait.accountcqrses.commonAPI.commands.DebitAccountCommand;
import ma.m0hamedait.accountcqrses.commonAPI.dtos.CreateAccountRequestDTO;
import ma.m0hamedait.accountcqrses.commonAPI.dtos.CreditAccountRequestDTO;
import ma.m0hamedait.accountcqrses.commonAPI.dtos.DebitAccountRequestDTO;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@AllArgsConstructor
@RestController
@RequestMapping("/commands/account")
public class AccountCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createAccount( @RequestBody CreateAccountRequestDTO request) {
        return commandGateway.send(new CreateAccountCommand(  // commandGateway is used to send commands to the command bus
                UUID.randomUUID().toString(),
                request.getInitialBalance(),
                request.getCurrency()
        ));
    }

    @PutMapping("/credit")
    public CompletableFuture<String> creditAccount( @RequestBody CreditAccountRequestDTO request) {
        return commandGateway.send(new CreditAccountCommand(  // commandGateway is used to send commands to the command bus
                request.getId(),
                request.getAmount(),
                request.getCurrency()
        ));
    }

    @PutMapping("/debit")
    public CompletableFuture<String> debitAccount(@RequestBody DebitAccountRequestDTO request) {
        return commandGateway.send(new DebitAccountCommand(  // commandGateway is used to send commands to the command bus
                request.getId(),
                request.getAmount(),
                request.getCurrency()
        ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/eventStore/{accountId}")
    public Stream eventStore(@PathVariable String accountId) {
        return eventStore.readEvents(accountId).asStream();
    }
}
