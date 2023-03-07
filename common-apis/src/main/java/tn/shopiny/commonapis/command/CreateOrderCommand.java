package tn.shopiny.commonapis.command;


import org.axonframework.modelling.command.AggregateIdentifier;
import tn.shopiny.commonapis.event.OrderDetails;

import java.util.UUID;

public class CreateOrderCommand{

    @AggregateIdentifier
    private final String orderId;
    private final OrderDetails orderDetails;
    private final UUID deliveryAddressId;
    private final String name;

    public CreateOrderCommand(String orderId, OrderDetails orderDetails, UUID deliveryAddressId, String name) {
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

    public UUID getDeliveryAddressId() {
        return deliveryAddressId;
    }

    public String getName() {
        return name;
    }
}
