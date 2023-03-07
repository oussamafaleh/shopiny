package tn.shopiny.orderservice.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Access(AccessType.FIELD)
public class MenuItem {

  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
  @Type(type = "uuid-char")
  private UUID id;

  private String name;
  @Embedded
  private Money price;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }


  public MenuItem(UUID id, String name, Money price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public MenuItem() {

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
}
