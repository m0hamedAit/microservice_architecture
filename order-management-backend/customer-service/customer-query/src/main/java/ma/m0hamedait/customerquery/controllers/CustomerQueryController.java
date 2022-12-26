package ma.m0hamedait.customerquery.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.m0hamedait.GetAllCustomersQuery;
import ma.m0hamedait.GetCustomerByIdQuery;
import ma.m0hamedait.customerquery.entities.Customer;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/queries/customer")
@AllArgsConstructor
@Slf4j
public class CustomerQueryController {
    private QueryGateway queryGateway;

    @GetMapping("/allCustomers")
    public List<Customer> getAllCustomers(){
        return queryGateway.query(new GetAllCustomersQuery(),
                ResponseTypes.multipleInstancesOf(Customer.class)).join();
    }

    @GetMapping("/{id}")
    public Customer customerInfo(@PathVariable String id){
        return queryGateway.query(new GetCustomerByIdQuery(id),
                ResponseTypes.instanceOf(Customer.class)).join();
    }
}
