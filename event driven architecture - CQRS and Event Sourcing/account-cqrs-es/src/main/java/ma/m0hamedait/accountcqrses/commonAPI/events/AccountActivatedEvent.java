package ma.m0hamedait.accountcqrses.commonAPI.events;

import lombok.Getter;
import ma.m0hamedait.accountcqrses.commonAPI.enums.AccountStatus;

public class AccountActivatedEvent extends BaseEvent<String> {

    @Getter
    private AccountStatus status;

    public AccountActivatedEvent(String id, AccountStatus status) {
        super(id);
        this.status = status;
    }
}
