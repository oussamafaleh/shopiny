package tn.shopiny.commonapis.command;


import org.axonframework.modelling.command.AggregateIdentifier;
import tn.shopiny.commonapis.event.OrderDetails;

public class ConfirmOrderCommand {

    @AggregateIdentifier
    private final String orderId;
    private final OrderDetails orderDetails;
    private final String deliveryAddressId;
    private final String name;

    public ConfirmOrderCommand(String orderId, OrderDetails orderDetails, String deliveryAddressId, String name) {
        this.orderId = orderId;
        this.orderDetails = orderDetails;
        this.deliveryAddressId = deliveryAddressId;
        this.name = name;
    }

    public String getOrderId() {
        return orderId;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public String getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public String getName() {
        return name;
    }
}
