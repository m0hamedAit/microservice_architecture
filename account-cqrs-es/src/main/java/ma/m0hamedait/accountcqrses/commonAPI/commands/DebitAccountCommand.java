package ma.m0hamedait.accountcqrses.commonAPI.commands;

public class CreateAccountCommand extends BaseCommand<String> {

    private Double InitialBalance;
    private String currency;

    public CreateAccountCommand(String id, Double initialBalance, String currency) {  //id is the account number
        super(id);
        InitialBalance = initialBalance;
        this.currency = currency;
    }
}
