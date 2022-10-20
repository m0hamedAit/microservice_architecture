package ma.m0hamedait.appcustomerservice;

import ma.m0hamedait.appcustomerservice.entities.Customer;
import ma.m0hamedait.appcustomerservice.repositories.CustomerRepository;
import ma.m0hamedait.appcustomerservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
public class AppCustomerServiceApplication {
	@Autowired
	private CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(AppCustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.save(new Customer("C01", "Mohamed", "mohamed@gmail.com"));
			customerRepository.save(new Customer("C02", "Ahmed", "ahmed@gmail.com"));
			customerRepository.save(new Customer("C03", "Ali", "ali@gmail.com"));
		};
	}


}
