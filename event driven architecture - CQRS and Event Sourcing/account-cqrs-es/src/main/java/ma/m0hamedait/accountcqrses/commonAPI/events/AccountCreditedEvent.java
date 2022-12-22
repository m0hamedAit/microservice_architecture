package ma.m0hamedait.accountcqrses.commonAPI.events;

import lombok.Getter;

import java.util.Date;

@Getter
public class AccountCreditedEvent extends BaseEvent<String> {
    private Double amount;
    private String currency;
    private Date date;

    public AccountCreditedEvent(String id, Double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
        this.date = new Date();
    }

}
