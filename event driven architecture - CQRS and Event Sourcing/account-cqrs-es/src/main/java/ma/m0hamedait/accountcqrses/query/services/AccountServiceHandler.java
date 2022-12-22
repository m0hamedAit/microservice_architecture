package ma.m0hamedait.accountcqrses.query.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.accountcqrses.commonAPI.enums.OperationType;
import ma.m0hamedait.accountcqrses.commonAPI.events.AccountActivatedEvent;
import ma.m0hamedait.accountcqrses.commonAPI.events.AccountCreatedEvent;
import ma.m0hamedait.accountcqrses.commonAPI.events.AccountCreditedEvent;
import ma.m0hamedait.accountcqrses.commonAPI.events.AccountDebitedEvent;
import ma.m0hamedait.accountcqrses.query.entities.Account;
import ma.m0hamedait.accountcqrses.query.entities.Operation;
import ma.m0hamedait.accountcqrses.query.queries.GetAccountByIdQuery;
import ma.m0hamedait.accountcqrses.query.queries.GetAllAccountsQuery;
import ma.m0hamedait.accountcqrses.query.repositories.AccountRepository;
import ma.m0hamedait.accountcqrses.query.repositories.OperationRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceHandler {
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;

    @EventHandler
    public void on(AccountCreatedEvent event) {
        log.info("*** AccountCreatedEvent received ***");
        Account account = new Account();
        account.setId(event.getId());
        account.setBalance(event.getInitialBalance());
        account.setCurrency(event.getCurrency());
        account.setStatus(event.getStatus());
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountActivatedEvent event) {
        log.info("*** AccountActivatedEvent received ***");
        Account account = accountRepository.getById(event.getId());
        account.setStatus(event.getStatus());
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountDebitedEvent event) {
        log.info("*** AccountDebitedEvent received ***");
        Account account = accountRepository.getById(event.getId());
        Operation operation = new Operation();
        operation.setAmount(event.getAmount());
        operation.setDate(event.getDate());
        operation.setType(OperationType.DEBIT);
        operation.setAccount(account);
        operationRepository.save(operation);
        account.setBalance(account.getBalance() - event.getAmount());
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountCreditedEvent event) {
        log.info("*** AccountCreditedEvent received ***");
        Account account = accountRepository.getById(event.getId());
        Operation operation = new Operation();
        operation.setAmount(event.getAmount());
        operation.setDate(event.getDate());
        operation.setType(OperationType.CREDIT);
        operation.setAccount(account);
        operationRepository.save(operation);
        account.setBalance(account.getBalance() + event.getAmount());
        accountRepository.save(account);
    }


    // Read Side (Queries)

    @QueryHandler
    public List<Account> on(GetAllAccountsQuery query){
        return accountRepository.findAll();
    }

    @QueryHandler
    public Account on(GetAccountByIdQuery query){
        return accountRepository.findById(query.getId()).get();
    }
}
