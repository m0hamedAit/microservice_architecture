package ma.m0hamedait.accountcqrses.commonAPI.commands;

import lombok.Getter;

@Getter
public class DebitAccountCommand extends BaseCommand<String> {

    private Double amount;
    private String currency;

    public DebitAccountCommand(String id, Double amount, String currency) {  //id is the account number
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
