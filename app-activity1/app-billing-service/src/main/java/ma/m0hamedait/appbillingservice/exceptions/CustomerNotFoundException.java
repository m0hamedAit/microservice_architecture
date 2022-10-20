package ma.m0hamedait.appbillingservice.exceptions;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String messages){
        super(messages);
    }
}
