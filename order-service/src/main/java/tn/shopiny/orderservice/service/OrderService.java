package tn.shopiny.orderservice.service;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.shopiny.commonapis.command.CreateOrderCommand;
import tn.shopiny.commonapis.event.OrderDetails;
import tn.shopiny.orderservice.exception.MenuItemNotFoundException;
import tn.shopiny.orderservice.exception.OrderNotFoundException;
import tn.shopiny.orderservice.exception.RestaurantNotFoundException;
import tn.shopiny.orderservice.model.*;
import tn.shopiny.orderservice.repository.OrderRepository;
import tn.shopiny.orderservice.repository.RestaurantRepository;

import java.util.List;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    private RestaurantRepository restaurantRepository;

    private final CommandGateway commandGateway;
    private final EventStore eventStore;

    public OrderService(OrderRepository orderRepository, RestaurantRepository restaurantRepository, CommandGateway commandGateway, EventStore eventStore) {
        this.orderRepository = orderRepository;
        this.restaurantRepository = restaurantRepository;
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }

    @Transactional
    public Order cancel(String orderId) {
        Order order = orderRepository.findById(UUID.fromString(orderId))
                .orElseThrow(() -> new OrderNotFoundException(orderId));

        return order;
    }

    public Order createOrder(String consumerId, UUID restaurantId, DeliveryInformation deliveryInformation, List<MenuItemIdAndQuantity> lineItems) {

        Restaurant restaurant = restaurantRepository.findByUuid(restaurantId).orElseThrow(() -> new RestaurantNotFoundException("no Restaurant was found with id : " + restaurantId));


        List<OrderLineItem> orderLineItems = makeOrderLineItems(lineItems, restaurant);
        Order order = new Order(consumerId, restaurant.getId().toString(), deliveryInformation, orderLineItems);

//        List<OrderDomainEvent> events = singletonList(new OrderCreatedEvent(
//                new OrderDetails(consumerId, restaurant.getId(), orderLineItems,
//                        order.getOrderTotal()),
//                deliveryInformation.getDeliveryAddress(),
//                restaurant.getName()));

        orderRepository.save(order);
        commandGateway.send(
                new CreateOrderCommand(
                        order.getId().toString(),
                        new OrderDetails(consumerId, restaurant.getId(), orderLineItems.stream().map(orderLineItem -> orderLineItem.getId() ).collect(Collectors.toList()), order.getOrderTotalAmount()),
                        deliveryInformation.getDeliveryAddress().getId(),
                        restaurant.getName()));


        return order;

    }

    private List<OrderLineItem> makeOrderLineItems(List<MenuItemIdAndQuantity> lineItems, Restaurant restaurant) {
        return lineItems.stream().map(li -> {
            MenuItem menuItem = restaurant.findMenuItem(li.getMenuItemId()).orElseThrow(() -> new MenuItemNotFoundException(li.getMenuItemId().toString()));
            return new OrderLineItem(li.getQuantity(), li.getMenuItemId(), menuItem.getName(), menuItem.getPrice());

        }).collect(Collectors.toList());
    }
}
