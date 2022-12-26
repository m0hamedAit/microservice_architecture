package ma.m0hamedait.ordercommand;

import lombok.AllArgsConstructor;
import ma.m0hamedait.CreateCategoryCommand;
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
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@Import({AxonConfig.class})
@EnableDiscoveryClient
@AllArgsConstructor
public class OrderCommandApplication {

    private CommandGateway commandGateway;

    public static void main(String[] args) {
        SpringApplication.run(OrderCommandApplication.class, args);
    }

    /*@Bean
    public CommandBus commandBus() {
        return SimpleCommandBus.builder().build();
    }*/

    @Bean
    public CommandLineRunner commandLineRunner() {
        Faker faker = new Faker();
        List<String> ids = new ArrayList<>();
        List<String> customerIds = new ArrayList<>();
        List<String>productIds = new ArrayList<>();
        Collections.addAll(customerIds, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        Collections.addAll(productIds, "1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        return args -> {
            // for each customer add 1 -10 orders, each order contanains 1-10 orderItems with productId



        };
    }

}
