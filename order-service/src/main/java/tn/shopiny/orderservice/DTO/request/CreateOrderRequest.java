package tn.shopiny.orderservice.DTO.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import tn.shopiny.orderservice.model.Address;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


public class CreateOrderRequest {

    private UUID restaurantId;
    private String consumerId;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deleveryTime;
    private List<LineItem> lineItems;
    private AddressRequest deliveryAddress;

    public CreateOrderRequest(UUID restaurantId, String consumerId, LocalDateTime deleveryTime, List<LineItem> lineItems, AddressRequest deliveryAddress) {
        this.restaurantId = restaurantId;
        this.consumerId = consumerId;
        this.deleveryTime = deleveryTime;
        this.lineItems = lineItems;
        this.deliveryAddress = deliveryAddress;
    }

    public UUID getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(UUID restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(String consumerId) {
        this.consumerId = consumerId;
    }

    public LocalDateTime getDeleveryTime() {
        return deleveryTime;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public AddressRequest getDeliveryAddress() {
        return deliveryAddress;
    }
    public Address getDeliveryAddressAsAddress() {
        return new Address(deliveryAddress.getStreet1(),deliveryAddress.getStreet2(), deliveryAddress.getCity(),deliveryAddress.getState(), deliveryAddress.getZip());
    }

    public void setDeliveryAddress(AddressRequest deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public static class LineItem {

        private UUID menuItemId;
        private int quantity;

        private LineItem() {
        }

        public LineItem(UUID menuItemId, int quantity) {
            this.menuItemId = menuItemId;

            this.quantity = quantity;
        }

        public UUID getMenuItemId() {
            return menuItemId;
        }

        public void setMenuItemId(UUID menuItemId) {
            this.menuItemId = menuItemId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
