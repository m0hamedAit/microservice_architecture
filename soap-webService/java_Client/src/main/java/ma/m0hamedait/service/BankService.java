
package ma.m0hamedait.service;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;



/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.0
 * Generated source version: 3.0
 * 
 */
@WebService(name = "BankService", targetNamespace = "http://ws.m0hamedAit.ma/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BankService {


    /**
     * 
     * @param code
     * @return
     *     returns ma.m0hamedait.ws.Account
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAccount", targetNamespace = "http://ws.m0hamedAit.ma/", className = "ma.m0hamedait.ws.GetAccount")
    @ResponseWrapper(localName = "getAccountResponse", targetNamespace = "http://ws.m0hamedAit.ma/", className = "ma.m0hamedait.ws.GetAccountResponse")
    @Action(input = "http://ws.m0hamedAit.ma/BankService/getAccountRequest", output = "http://ws.m0hamedAit.ma/BankService/getAccountResponse")
    public Account getAccount(
        @WebParam(name = "code", targetNamespace = "")
        int code);

    /**
     * 
     * @return
     *     returns java.util.List<ma.m0hamedait.ws.Account>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listAccounts", targetNamespace = "http://ws.m0hamedAit.ma/", className = "ma.m0hamedait.ws.ListAccounts")
    @ResponseWrapper(localName = "listAccountsResponse", targetNamespace = "http://ws.m0hamedAit.ma/", className = "ma.m0hamedait.ws.ListAccountsResponse")
    @Action(input = "http://ws.m0hamedAit.ma/BankService/listAccountsRequest", output = "http://ws.m0hamedAit.ma/BankService/listAccountsResponse")
    public List<Account> listAccounts();

    /**
     * 
     * @param amount
     * @return
     *     returns double
     */
    @WebMethod(operationName = "Convert")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Convert", targetNamespace = "http://ws.m0hamedAit.ma/", className = "ma.m0hamedait.ws.Convert")
    @ResponseWrapper(localName = "ConvertResponse", targetNamespace = "http://ws.m0hamedAit.ma/", className = "ma.m0hamedait.ws.ConvertResponse")
    @Action(input = "http://ws.m0hamedAit.ma/BankService/ConvertRequest", output = "http://ws.m0hamedAit.ma/BankService/ConvertResponse")
    public double convert(
        @WebParam(name = "amount", targetNamespace = "")
        double amount);

}
