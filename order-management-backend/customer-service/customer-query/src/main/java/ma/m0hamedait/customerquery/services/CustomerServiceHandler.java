package ma.m0hamedait.customerquery.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import ma.m0hamedait.*;
import ma.m0hamedait.customerquery.entities.Customer;
import ma.m0hamedait.customerquery.repositories.CustomerRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceHandler {
    private CustomerRepository customerRepository;

    @EventHandler
    public void on(CustomerCreatedEvent event){
        log.info("*** CustomerCreatedEvent received ***");
        Customer customer = new Customer();
        customer.setId(event.getId());
        customer.setName(event.getName());
        customer.setEmail(event.getEmail());
        customer.setPhone(event.getPhone());
        customer.setAddress(event.getAddress());
        customerRepository.save(customer);
    }

    @EventHandler
    public void on(CustomerUpdatedEvent event){
        log.info("*** CustomerUpdatedEvent received ***");
        Customer customer = customerRepository.findById(event.getId()).get();
        customer.setName(event.getName() != null ? event.getName() : customer.getName());
        customer.setEmail(event.getEmail() != null ? event.getEmail() : customer.getEmail());
        customer.setPhone(event.getPhone() != null ? event.getPhone() : customer.getPhone());
        customer.setAddress(event.getAddress() != null ? event.getAddress() : customer.getAddress());
        customerRepository.save(customer);
    }

    @EventHandler
    public void on(CustomerDeletedEvent event){
        log.info("*** CustomerDeletedEvent received ***");
        customerRepository.deleteById(event.getId());
    }

    @QueryHandler
    public List<Customer> on(GetAllCustomersQuery query){
        log.info("*** GetAllCustomersQuery received ***");
        return customerRepository.findAll();
    }

    @QueryHandler
    public Customer on(GetCustomerByIdQuery query){
        log.info("*** GetCustomerByIdQuery received ***");
        return customerRepository.findById(query.getId()).get();
    }

}
