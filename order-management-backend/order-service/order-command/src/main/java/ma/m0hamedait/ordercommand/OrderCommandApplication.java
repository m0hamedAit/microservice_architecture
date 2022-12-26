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
public class OrderCommandApplication {


    public static void main(String[] args) {
        SpringApplication.run(OrderCommandApplication.class, args);
    }

    /*@Bean
    public CommandBus commandBus() {
        return SimpleCommandBus.builder().build();
    }*/



}
