package ma.m0hamedAit.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;

@WebService(serviceName="BankWS")
public class BankService {
    @WebMethod(operationName="Convert")
    public double convertEuroToDH(@WebParam(name="amount") double mt) {
        return mt * 10.54;
    }
    @WebMethod
    public Account getAccount(@WebParam(name="code") int code){
        return new Account(code, 1000, new Date());
    }
    @WebMethod
    public List<Account> listAccounts(){
        return List.of(
                new Account(1, 1000, new Date()),
                new Account(2, 2000, new Date()),
                new Account(3, 3000, new Date())
        );

    }
}
