package ma.m0hamedait.accountcqrses.commonAPI.events;

import lombok.Getter;
import ma.m0hamedait.accountcqrses.commonAPI.enums.AccountStatus;

@Getter
public class AccountCreatedEvent extends BaseEvent<String> {
    private Double initialBalance;
    private String currency;
    private AccountStatus status;
    public AccountCreatedEvent(String id, Double initialBalance, String currency, AccountStatus status) {
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
        this.status = status;
    }

}
