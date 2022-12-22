package ma.m0hamedait.accountcqrses.commonAPI.exceptions;

public class AmountNegativeException extends RuntimeException {
    public AmountNegativeException(String msg) {
        super(msg);
    }
}
