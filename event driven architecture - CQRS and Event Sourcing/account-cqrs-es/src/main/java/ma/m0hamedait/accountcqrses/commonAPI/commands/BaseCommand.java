package ma.m0hamedait.accountcqrses.commonAPI.commands;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public abstract class BaseCommand<T> {
    @TargetAggregateIdentifier   // <- The identifier of the aggregate targeted by this command
    @Getter
    private T id;   // commands and events are immutable, so we can only use getters

    public BaseCommand(T id) {
        this.id = id;
    }
}
