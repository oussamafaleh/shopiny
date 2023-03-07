package tn.shopiny.commonapis.event;


import java.util.UUID;

public class OrderCreatedEvent {

    private final String Status;
    private String orderId;
    private OrderDetails orderDetails;
    private UUID deliveryAddressId;
    private String name;

    public OrderCreatedEvent(String orderId , OrderDetails orderDetails, UUID deliveryAddressId, String name, String status) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
        this.deliveryAddressId = deliveryAddressId;
        this.name = name;
        this.Status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public UUID getdeliveryAddressId() {
        return deliveryAddressId;
    }

    public void setdeliveryAddressId(UUID deliveryAddressId) {
        this.deliveryAddressId = deliveryAddressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return Status;
    }
}
