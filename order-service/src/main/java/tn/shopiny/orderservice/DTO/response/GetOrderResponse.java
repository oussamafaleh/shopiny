package tn.shopiny.orderservice.DTO.response;

import tn.shopiny.orderservice.model.Money;
import tn.shopiny.orderservice.model.Order;
import tn.shopiny.orderservice.model.OrderState;

import java.util.UUID;


public class GetOrderResponse {

    private UUID orderId;
    private OrderState state;
    private Money orderTotal;

    public GetOrderResponse(Order order){
        this.orderId = order.getId();
        this.state = order.getState();
        this.orderTotal = order.getOrderTotal();
    }
    public GetOrderResponse(UUID orderId, OrderState state, Money orderTotal) {
        this.orderId = orderId;
        this.state = state;
        this.orderTotal = orderTotal;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Money getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Money orderTotal) {
        this.orderTotal = orderTotal;
    }
}
