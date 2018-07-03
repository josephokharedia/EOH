package za.co.digitalplatoon.invoiceservice.invoice.interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.digitalplatoon.invoiceservice.invoice.application.InvoiceApplication;
import za.co.digitalplatoon.invoiceservice.invoice.domain.invoice.Invoice;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("invoices")
public class InvoiceController {

    @Autowired
    InvoiceApplication application;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addInvoice(@RequestBody @NotNull Invoice invoice) {
        application.addInvoice(invoice);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Invoice> viewAllInvoices() {
        return application.viewAllInvoices();
    }

    @GetMapping(value = "/{invoiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Invoice> viewInvoice(@PathVariable("invoiceId") Long id) {
        return application.viewInvoice(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
