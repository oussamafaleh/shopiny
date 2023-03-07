package tn.shopiny.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.shopiny.orderservice.model.Order;
import tn.shopiny.orderservice.model.Restaurant;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface RestaurantRepository extends CrudRepository<Order, UUID> {
    @Query("SELECT r FROM Restaurant as r WHERE  CAST(r.id as org.hibernate.type.UUIDCharType) = (:uuid)")
    Optional<Restaurant> findByUuid(@Param("uuid") UUID uuid);
}