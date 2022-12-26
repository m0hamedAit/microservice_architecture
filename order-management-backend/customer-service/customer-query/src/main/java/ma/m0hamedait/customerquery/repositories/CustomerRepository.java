package ma.m0hamedait.customerquery.repositories;

import ma.m0hamedait.customerquery.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
