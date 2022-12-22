package ma.m0hamedait.accountcqrses.commonAPI.exceptions;

public class BalanceInsufficientException extends RuntimeException {
    public BalanceInsufficientException(String msg)
    {
        super(msg);
    }
}
