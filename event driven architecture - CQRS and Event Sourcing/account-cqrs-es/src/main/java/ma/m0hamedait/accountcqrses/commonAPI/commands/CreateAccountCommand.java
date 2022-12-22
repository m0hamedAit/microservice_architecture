package ma.m0hamedait.accountcqrses.commonAPI.commands;

import lombok.Getter;

@Getter
public class CreateAccountCommand extends BaseCommand<String> {
    private Double initialBalance;
    private String currency;

    public CreateAccountCommand(String id, Double initialBalance, String currency) {  //id is the account number
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
    }

}
