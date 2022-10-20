package ma.m0hamedait.appbillingservice.mappers;

import ma.m0hamedait.appbillingservice.dtos.InvoiceRequestDTO;
import ma.m0hamedait.appbillingservice.dtos.InvoiceResponseDTO;
import ma.m0hamedait.appbillingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}
