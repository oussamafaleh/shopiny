package tn.shopiny.orderservice.model;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Entity
public class OrderLineItems {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<OrderLineItem> lineItems;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OrderLineItems() {
    }

    public OrderLineItems(List<OrderLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<OrderLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<OrderLineItem> lineItems) {
        this.lineItems = lineItems;
    }
    public OrderLineItem findOrderLineItemById(String lineItemId){
        return lineItems.stream().filter(lineItem -> lineItem.getMenuItemId().equals(lineItemId)).findFirst().get();
    }

    Money orderTotal(){
        return lineItems.stream().map(OrderLineItem::getTotal).reduce(Money.ZERO,Money::add);
    }
    String orderTotalAmount(){
        return lineItems.stream().map(OrderLineItem::getTotal).reduce(Money.ZERO,Money::add).asString();
    }
}
