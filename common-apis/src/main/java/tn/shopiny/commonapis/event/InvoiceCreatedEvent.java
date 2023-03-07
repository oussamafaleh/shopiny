package tn.shopiny.commonapis.event;


public class InvoiceCreatedEvent {

    public final String paymentId;

    public final String orderId;

    private String status;
    public InvoiceCreatedEvent(String paymentId, String orderId) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.status = "INVOICE_CREATED";
    }
}
