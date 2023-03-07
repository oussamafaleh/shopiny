package tn.shopiny.commonapis.event;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


public class OrderDetails {

    private String consumerId;
    private UUID restaurantId;
    private List<UUID> orderLineItemIds;
    private String orderTotal;

    public OrderDetails(String consumerId, UUID restaurantId, List<UUID> orderLineItemIds, String orderTotal) {
        this.consumerId = consumerId;
        this.restaurantId = restaurantId;
        this.orderLineItemIds = orderLineItemIds;
        this.orderTotal = orderTotal;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<UUID> getOrderLineItems() {
        return orderLineItemIds;
    }

    public void setOrderLineItems(List<UUID> orderLineItems) {
        this.orderLineItemIds = orderLineItems;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }
}
