package ma.m0hamedait.accountcqrses.commonAPI.events;


import lombok.Getter;

public abstract class BaseEvent<T> {

    @Getter private T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}
