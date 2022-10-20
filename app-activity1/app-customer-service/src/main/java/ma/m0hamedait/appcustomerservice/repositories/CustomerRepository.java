package ma.m0hamedait.appcustomerservice.repositories;

import ma.m0hamedait.appcustomerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
}
