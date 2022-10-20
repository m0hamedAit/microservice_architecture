package ma.m0hamedait.appcustomerservice.mappers;

import ma.m0hamedait.appcustomerservice.dtos.CustomerRequestDTO;
import ma.m0hamedait.appcustomerservice.dtos.CustomerResponseDTO;
import ma.m0hamedait.appcustomerservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDTO customerToCustomerDTO(Customer customer);
    Customer customerRequestDTOToCustomer(CustomerRequestDTO customerRequestDTO);
}
