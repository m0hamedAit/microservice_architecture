package ma.m0hamedait.inventorycommand;

import lombok.AllArgsConstructor;
import ma.m0hamedait.CreateCategoryCommand;
import ma.m0hamedait.CreateCustomerCommand;
import ma.m0hamedait.CreateProductCommand;
import ma.m0hamedait.ProductStatus;
import ma.m0hamedait.ordermanagementbackend.AxonConfig;
import net.datafaker.Faker;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@Import({AxonConfig.class})
@EnableDiscoveryClient
@AllArgsConstructor
public class InventoryCommandApplication {

    public CommandGateway commandGateway;

    public static void main(String[] args) {
        SpringApplication.run(InventoryCommandApplication.class, args);
    }

    /*@Bean
    public CommandBus commandBus() {
        return SimpleCommandBus.builder().build();
    }*/


    @Bean
    public CommandLineRunner commandLineRunner() {
        Faker faker = new Faker();
        List<String> ids = new ArrayList<>();
        return args -> {
            String id = UUID.randomUUID().toString();
            ids.add(id);
            for (int i = 0; i < 10; i++) {
                commandGateway.send(new CreateCategoryCommand(
                        id,
                        faker.name().title(),
                        faker.text().text()
                ));
            }

            for (String categoryId : ids) {
                for (int i = 0; i < faker.number().numberBetween(5, 10); i++) {
                    commandGateway.send(new CreateProductCommand(
                            UUID.randomUUID().toString(),
                            faker.name().fullName(),
                            faker.number().randomDouble(2, 150, 10000),
                            faker.number().numberBetween(1, 100),
                            faker.options().option(ProductStatus.ABONDONED, ProductStatus.PRODUCTION, ProductStatus.AVAILABLE, ProductStatus.UNAVAILABLE),
                            categoryId
                    ));
                }
            }
        };
    }
}
