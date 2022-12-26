package ma.m0hamedait.customerquery;

import ma.m0hamedait.CreateCustomerCommand;
import ma.m0hamedait.ordermanagementbackend.AxonConfig;
import net.datafaker.Faker;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.UUID;

@SpringBootApplication
@Import({AxonConfig.class})
@EnableDiscoveryClient
public class CustomerQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerQueryApplication.class, args);
    }

}
