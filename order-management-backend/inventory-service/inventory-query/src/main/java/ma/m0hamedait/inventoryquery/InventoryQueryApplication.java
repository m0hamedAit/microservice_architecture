package ma.m0hamedait.inventoryquery;

import ma.m0hamedait.ordermanagementbackend.AxonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AxonConfig.class})
@EnableDiscoveryClient
public class InventoryQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryQueryApplication.class, args);
    }

}
