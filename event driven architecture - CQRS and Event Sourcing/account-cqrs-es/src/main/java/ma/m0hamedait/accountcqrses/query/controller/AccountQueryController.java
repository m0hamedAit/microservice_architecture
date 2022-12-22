package ma.m0hamedait.accountcqrses.query.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.accountcqrses.query.entities.Account;
import ma.m0hamedait.accountcqrses.query.queries.GetAccountByIdQuery;
import ma.m0hamedait.accountcqrses.query.queries.GetAllAccountsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/query/accounts")
@AllArgsConstructor
@Slf4j
public class AccountQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/allAccounts")
    public List<Account>  accountList(){
        return queryGateway.query(new GetAllAccountsQuery(),
                ResponseTypes.multipleInstancesOf(Account.class)).join(); // ResponseTypes.multipleInstancesOf(Account.class) : means that typeof return has to be a list<Account>
    }

    @GetMapping("/byId/{id}")
    public Account accountInfo(@PathVariable String id){
        return queryGateway.query(new GetAccountByIdQuery(id), ResponseTypes.instanceOf(Account.class)).join();
    }
}
