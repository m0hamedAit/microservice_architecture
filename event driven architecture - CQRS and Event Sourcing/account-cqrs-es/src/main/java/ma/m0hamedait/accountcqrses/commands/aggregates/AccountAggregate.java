package ma.m0hamedait.accountcqrses.commands.aggregates;

import ma.m0hamedait.accountcqrses.commonAPI.commands.CreateAccountCommand;
import ma.m0hamedait.accountcqrses.commonAPI.commands.CreditAccountCommand;
import ma.m0hamedait.accountcqrses.commonAPI.commands.DebitAccountCommand;
import ma.m0hamedait.accountcqrses.commonAPI.enums.AccountStatus;
import ma.m0hamedait.accountcqrses.commonAPI.events.AccountActivatedEvent;
import ma.m0hamedait.accountcqrses.commonAPI.events.AccountCreatedEvent;
import ma.m0hamedait.accountcqrses.commonAPI.events.AccountCreditedEvent;
import ma.m0hamedait.accountcqrses.commonAPI.events.AccountDebitedEvent;
import ma.m0hamedait.accountcqrses.commonAPI.exceptions.BalanceInsufficientException;
import ma.m0hamedait.accountcqrses.commonAPI.exceptions.InitialBalanceNegativeException;
import ma.m0hamedait.accountcqrses.commonAPI.exceptions.AmountNegativeException;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

@Aggregate
public class AccountAggregate {
    @AggregateIdentifier
    private String accountID;
    private double balance;
    private String currency;
    private AccountStatus status;

    public AccountAggregate() { // used by Axon to restore the aggregate from the event store
        //required by Axon
    }

    @CommandHandler
    public AccountAggregate(CreateAccountCommand command) {
        System.out.println(command.getInitialBalance());
        if(command.getInitialBalance() < 0)
            throw new InitialBalanceNegativeException("Impossible :: Initial balance cannot be negative");
        AggregateLifecycle.apply(new AccountCreatedEvent(command.getId(),   // command data will be transferred to the event
                command.getInitialBalance(),
                command.getCurrency(),
                AccountStatus.CREATED
        ));

    }

    @EventSourcingHandler
    public void on(AccountCreatedEvent event) {
        this.accountID = event.getId();
        this.balance = event.getInitialBalance();
        this.currency = event.getCurrency();
        this.status = AccountStatus.CREATED;
        AggregateLifecycle.apply(new AccountActivatedEvent(event.getId(),   // command data will be transferred to the event
                AccountStatus.ACTIVATED));
    }

    @EventSourcingHandler
    public void on(AccountActivatedEvent event) {
        this.status = event.getStatus();
    }

    //credit
    @CommandHandler
    public void handle(CreditAccountCommand command) {
        if(command.getAmount() < 0)
            throw new AmountNegativeException("Impossible :: Credit amount cannot be negative");
        AggregateLifecycle.apply(new AccountCreditedEvent(
                command.getId(),
                command.getAmount(),
                command.getCurrency()));
    }

    @EventSourcingHandler
    public void on(AccountCreditedEvent event) {
        this.balance += event.getAmount();
    }

    //debit
    @CommandHandler
    public void handle(DebitAccountCommand command) {
        if(command.getAmount() < 0)
            throw new AmountNegativeException("Impossible :: Credit amount cannot be negative");
        if(this.balance< command.getAmount())
            throw new BalanceInsufficientException("Impossible :: Insufficient balance \nYour balance is : " + this.balance);

        AggregateLifecycle.apply(new AccountDebitedEvent(
                command.getId(),
                command.getAmount(),
                command.getCurrency()));
    }

    @EventSourcingHandler
    public void on(AccountDebitedEvent event) {
        this.balance -= event.getAmount();
    }
}
