package ma.m0hamedait;

import ma.m0hamedait.service.BankService;
import ma.m0hamedait.service.BankWS;

public class Main {
    public static void main(String[] args) {
        BankService stub = new BankWS().getBankServicePort();
        System.out.println(stub.convert(100));
    }
}