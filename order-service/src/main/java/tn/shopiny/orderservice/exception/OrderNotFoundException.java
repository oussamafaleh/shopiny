package tn.shopiny.orderservice.exception;



public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String orderId) {
        super("Order not found" + orderId);
    }
}