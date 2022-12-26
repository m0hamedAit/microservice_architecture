package ma.m0hamedait.customercommand;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class CustomerCommandApplication {

    private CommandGateway commandGateway;

    public static void main(String[] args) {
        SpringApplication.run(CustomerCommandApplication.class, args);
    }

   /* @Bean
    public CommandBus commandBus() {
        return SimpleCommandBus.builder().build();
    }*/


    @Bean
    public CommandLineRunner commandLineRunner() {
        Faker faker = new Faker();
        return args -> {

            for (int i = 0; i < 20; i++) {
                commandGateway.send(new CreateCustomerCommand(
                        UUID.randomUUID().toString(),
                        faker.name().fullName(),
                        faker.internet().emailAddress(),
                        faker.phoneNumber().phoneNumber(),
                        faker.address().streetAddress()
                ));
            }
        };
    }
}
