package tn.shopiny.commonapis.event;


public class OrderConfirmedEvent {

    private final Object status;
    private String orderId;
    private OrderDetails orderDetails;
    private String  deliveryAddressId;
    private String name;

    public OrderConfirmedEvent(String orderId , OrderDetails orderDetails, String  deliveryAddressId, String name, String status) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
        this. deliveryAddressId =  deliveryAddressId;
        this.name = name;
        this.status = status;
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

    public String getDeliveryAddressId() {
        return  deliveryAddressId;
    }

    public void setDeliveryAddressId(String  deliveryAddressId) {
        this. deliveryAddressId =  deliveryAddressId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getStatus() {
        return status;
    }
}
