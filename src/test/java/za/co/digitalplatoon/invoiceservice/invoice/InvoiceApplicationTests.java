package za.co.digitalplatoon.invoiceservice.invoice;

import org.junit.Before;
import org.junit.Test;
import za.co.digitalplatoon.invoiceservice.invoice.domain.invoice.Invoice;
import za.co.digitalplatoon.invoiceservice.invoice.domain.invoice.LineItem;

import java.math.BigDecimal;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class InvoiceApplicationTests {

    Invoice invoice;

    @Before
    public void init() {
        invoice = new Invoice();
        invoice.setVatRate(15L);
        LineItem lineItem1 = new LineItem();
        lineItem1.setId(1L);
        lineItem1.setQuantity(1L);
        lineItem1.setDescription("Pencil");
        lineItem1.setUnitPrice(BigDecimal.valueOf(2.00));

        LineItem lineItem2 = new LineItem();
        lineItem2.setId(2L);
        lineItem2.setQuantity(1L);
        lineItem2.setDescription("Pencil");
        lineItem2.setUnitPrice(BigDecimal.valueOf(2.00));

        invoice.getLineItems().add(lineItem1);
        invoice.getLineItems().add(lineItem2);

    }

//    @Test
//    public void contextLoads() {
//    }

    @Test
    public void testTotalOfInvoice() {
        System.out.println("subTotal: " + invoice.getSubTotal());
        System.out.println("vat: " + invoice.getVat());
        System.out.println("total: " + invoice.getTotal());

//        assertThat(invoice.getSubTotal(), is(0));
//        assertThat(invoice.getTotal(), is(0));
//        assertThat(invoice.getVat(), is(0));
    }

}
