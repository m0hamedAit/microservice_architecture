package ma.m0hamedait.accountcqrses.commonAPI.events;

import lombok.Getter;

import java.util.Date;

@Getter
public class AccountDebitedEvent extends BaseEvent<String> {
    private Double amount;
    private String currency;

    private Date date;

    public AccountDebitedEvent(String id, Double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
        this.date = new Date();
    }

}
