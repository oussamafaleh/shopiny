package tn.shopiny.paymentservice.DTO.response;


import java.util.UUID;

public class CreatePaymentResponse {

    private String orderId ;
    private String paymentId ;

    public CreatePaymentResponse(String orderId, String paymentId) {
        this.orderId = orderId;
        this.paymentId = paymentId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPaymentId() {
        return paymentId;
    }
}
