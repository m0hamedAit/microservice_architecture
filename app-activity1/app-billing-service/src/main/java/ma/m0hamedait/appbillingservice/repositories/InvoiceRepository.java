package ma.m0hamedait.appbillingservice.repositories;

import ma.m0hamedait.appbillingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {
    List<Invoice> findByCustomerID(String customerId);
}
