package ma.m0hamedait.appbillingservice.services;

import ma.m0hamedait.appbillingservice.dtos.InvoiceRequestDTO;
import ma.m0hamedait.appbillingservice.dtos.InvoiceResponseDTO;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO getInvoice(String invoiceId);
    List<InvoiceResponseDTO> customerInvoices(String customer);
    List<InvoiceResponseDTO> getAllInvoices();
}
