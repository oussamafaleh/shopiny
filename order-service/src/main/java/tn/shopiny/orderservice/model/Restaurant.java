package tn.shopiny.orderservice.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "restaurant")
@Access(AccessType.FIELD)
public class Restaurant {



    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    private String name;
    @OneToMany
    private List<MenuItem> menuItems;



    public Restaurant(UUID  id, String name, List<MenuItem> menuItems) {
        this.id = id;
        this.name = name;
        this.menuItems = menuItems;
    }

    public Restaurant() {

    }

    public UUID   getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public Optional<MenuItem> findMenuItem(UUID itemId){
        return menuItems.stream().filter((i)-> i.getId().toString().equals(itemId.toString())).findFirst();
    }
}