package ma.m0hamedait.appcustomerservice.web;

import ma.m0hamedait.appcustomerservice.dtos.CustomerRequestDTO;
import ma.m0hamedait.appcustomerservice.dtos.CustomerResponseDTO;
import ma.m0hamedait.appcustomerservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path= "/api/v1/customers")
public class CustomerRestAPI {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping(path="/{id}")
    public CustomerResponseDTO getCustomer(@PathVariable String id){
        System.out.println("id = " + id);
        return customerService.getCustomer(id);
    }

    @PostMapping(path="")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){
        return customerService.save(customerRequestDTO);
    }


}
