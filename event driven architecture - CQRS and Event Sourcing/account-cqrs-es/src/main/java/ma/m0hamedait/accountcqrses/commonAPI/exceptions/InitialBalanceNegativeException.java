package ma.m0hamedait.accountcqrses.commonAPI.exceptions;

public class InitialBalanceNegativeException extends RuntimeException {
    public InitialBalanceNegativeException(String msg) {
        super(msg);
    }
}
