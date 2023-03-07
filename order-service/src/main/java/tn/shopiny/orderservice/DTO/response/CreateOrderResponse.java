package tn.shopiny.orderservice.DTO.response;


import java.util.UUID;

public class CreateOrderResponse {

    private UUID orderId ;

    public CreateOrderResponse(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getOrderId() {
        return orderId;
    }
}
