package ma.m0hamedait.appcustomerservice.services;

import lombok.AllArgsConstructor;
import ma.m0hamedait.appcustomerservice.dtos.CustomerRequestDTO;
import ma.m0hamedait.appcustomerservice.dtos.CustomerResponseDTO;
import ma.m0hamedait.appcustomerservice.entities.Customer;
import ma.m0hamedait.appcustomerservice.mappers.CustomerMapper;
import ma.m0hamedait.appcustomerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        customerRequestDTO.setId(UUID.randomUUID().toString());
        Customer customer = customerMapper.customerRequestDTOToCustomer(customerRequestDTO);
        customer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(customer);
    }

    @Override
    public CustomerResponseDTO update(String id, CustomerRequestDTO customerRequestDTO) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Customer not found"));
        customer.setName(customerRequestDTO.getName());
        customer.setEmail(customerRequestDTO.getEmail());
        customer = customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(customer);
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new RuntimeException("Customer not found"));
        return customerMapper.customerToCustomerDTO(customer);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(customerMapper::customerToCustomerDTO).collect(Collectors.toList());
    }
}
