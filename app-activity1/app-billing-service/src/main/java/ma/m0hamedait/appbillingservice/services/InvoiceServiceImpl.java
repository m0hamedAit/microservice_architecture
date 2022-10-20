package ma.m0hamedait.appbillingservice.services;

import lombok.AllArgsConstructor;
import ma.m0hamedait.appbillingservice.dtos.InvoiceRequestDTO;
import ma.m0hamedait.appbillingservice.dtos.InvoiceResponseDTO;
import ma.m0hamedait.appbillingservice.entities.Customer;
import ma.m0hamedait.appbillingservice.entities.Invoice;
import ma.m0hamedait.appbillingservice.exceptions.CustomerNotFoundException;
import ma.m0hamedait.appbillingservice.mappers.InvoiceMapper;
import ma.m0hamedait.appbillingservice.openFeign.CustomerServiceRestClient;
import ma.m0hamedait.appbillingservice.repositories.InvoiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerServiceRestClient customerServiceRestClient;

    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
        Customer customer = null;
        // Verification de l'integration customer/invoice
        try{
            customer=customerServiceRestClient.customerById(invoiceRequestDTO.getCustomerID());
        }
        catch(Exception e){
            throw new CustomerNotFoundException("Customer not found !!");
        }
        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());
        invoice = invoiceRepository.save(invoice);
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).orElseThrow(()->new RuntimeException("Invoice not found !!"));
        Customer customer=customerServiceRestClient.customerById(invoice.getCustomerID());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> customerInvoices(String customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerID(customerId);
        for(Invoice invoice: invoices){
            Customer customer = customerServiceRestClient.customerById(invoice.getCustomerID());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(invoiceMapper::fromInvoice).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceResponseDTO> getAllInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        for(Invoice invoice: invoices){
            Customer customer = customerServiceRestClient.customerById(invoice.getCustomerID());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(invoiceMapper::fromInvoice).collect(Collectors.toList());
    }
}
