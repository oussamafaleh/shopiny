package tn.shopiny.orderservice.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "user_order")
public class Order {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Version
    private Long version;

    private String consumerId;

    private String restaurantId;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "order_line_items_id")
    private OrderLineItems orderLineItems;


    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "delivery_information_id")
    private DeliveryInformation deliveryInformation;



    @Embedded
    @JoinColumn(name = "payment_information_id")
    private PaymentInformation paymentInformation;

    private Money orderMinimum = new Money(Integer.MAX_VALUE);

    public PaymentInformation getPaymentInformation() {
        return paymentInformation;
    }

    public void setPaymentInformation(PaymentInformation paymentInformation) {
        this.paymentInformation = paymentInformation;
    }

    public void setDeliveryInformation(DeliveryInformation deliveryInformation) {
        this.deliveryInformation = deliveryInformation;
    }

    public OrderLineItems getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(OrderLineItems orderLineItems) {
        this.orderLineItems = orderLineItems;
    }


    public Order() {
    }

    public Order(String consumerId, String restaurantId, DeliveryInformation deliveryInformation, List<OrderLineItem> orderLineItems) {
        this.consumerId = consumerId;
        this.restaurantId = restaurantId;
        this.deliveryInformation = deliveryInformation;
        this.orderLineItems = new OrderLineItems(orderLineItems);
        this.state = OrderState.APPROVAL_PENDING;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public DeliveryInformation getDeliveryInformation() {
        return deliveryInformation;
    }

    public Money getOrderTotal() {
        return orderLineItems.orderTotal();
    }
    public String getOrderTotalAmount() {
        return orderLineItems.orderTotalAmount();
    }

    public Long getVersion() {
        return version;
    }

    public List<OrderLineItem> getLineItems() {
        return orderLineItems.getLineItems();
    }

    public OrderState getState() {
        return state;
    }

    public String getRestaurantId() {
        return restaurantId;
    }


    public String getConsumerId() {
        return consumerId;
    }
}