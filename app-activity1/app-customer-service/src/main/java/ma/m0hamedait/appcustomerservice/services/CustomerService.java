package ma.m0hamedait.appcustomerservice.services;

import ma.m0hamedait.appcustomerservice.dtos.CustomerRequestDTO;
import ma.m0hamedait.appcustomerservice.dtos.CustomerResponseDTO;
import ma.m0hamedait.appcustomerservice.entities.Customer;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO update(String id, CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO getCustomer(String id);
    List<CustomerResponseDTO> getAllCustomers();
}
