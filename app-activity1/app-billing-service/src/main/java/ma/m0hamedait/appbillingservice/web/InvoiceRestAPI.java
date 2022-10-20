package ma.m0hamedait.appbillingservice.web;

import ma.m0hamedait.appbillingservice.dtos.InvoiceRequestDTO;
import ma.m0hamedait.appbillingservice.dtos.InvoiceResponseDTO;
import ma.m0hamedait.appbillingservice.entities.Invoice;
import ma.m0hamedait.appbillingservice.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/invoices")
public class InvoiceRestAPI {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping(path="/{invoiceId}")
    public InvoiceResponseDTO getInvoice(@PathVariable String invoiceId){
        return invoiceService.getInvoice(invoiceId);
    }

    @GetMapping(path="/customer/{customerId}")
    public List<InvoiceResponseDTO> getCustomerInvoices(@PathVariable String customerId){
        return invoiceService.customerInvoices(customerId);
    }

    @GetMapping(path="")
    public List<InvoiceResponseDTO> getAllInvoices(){
        return invoiceService.getAllInvoices();
    }

    @PostMapping("")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO){
        return invoiceService.save(invoiceRequestDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
