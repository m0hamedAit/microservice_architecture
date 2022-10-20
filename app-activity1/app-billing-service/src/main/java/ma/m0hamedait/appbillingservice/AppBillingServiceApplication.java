package ma.m0hamedait.appbillingservice;

import ma.m0hamedait.appbillingservice.dtos.InvoiceRequestDTO;
import ma.m0hamedait.appbillingservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients   //to be able to inject openFeign
public class AppBillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppBillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(InvoiceService invoiceService){
		return args -> {
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(60000), "C01"));
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(80000), "C02"));
			invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(100000), "C03"));
		};
	}

}
