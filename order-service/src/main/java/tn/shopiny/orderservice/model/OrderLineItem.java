package tn.shopiny.orderservice.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;


@Entity
public class OrderLineItem {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    private int quantity;
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID menuItemId;
    private String name;


    @AttributeOverrides(@AttributeOverride(name="amount", column=@Column(name="price")))
    private Money price;

    public UUID getId() {
        return id;
    }


    public OrderLineItem() {
    }

    public OrderLineItem(int quantity, UUID menuItemId, String name, Money price) {
        this.quantity = quantity;
        this.menuItemId = menuItemId;
        this.name = name;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public UUID getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(UUID menuItemId) {
        this.menuItemId = menuItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public Money getTotal(){
        return price.multiply(quantity);
    }
}
