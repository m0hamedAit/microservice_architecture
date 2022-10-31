package ma.m0hamedAit;

import jakarta.xml.ws.Endpoint;
import ma.m0hamedAit.ws.BankService;

public class ServerJWS {
    public static void main(String[] args) {
        // start an http server on port 9191
        Endpoint.publish("http://0.0.0.0:9191/", new BankService());
        System.out.println("> Server started");
    }
}
