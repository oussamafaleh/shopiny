package tn.shopiny.orderservice.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import static org.axonframework.modelling.command.AggregateLifecycle.apply;

import org.axonframework.queryhandling.QueryHandler;
import org.axonframework.spring.stereotype.Aggregate;
import tn.shopiny.commonapis.command.ConfirmOrderCommand;
import tn.shopiny.commonapis.command.CreateOrderCommand;
import tn.shopiny.commonapis.event.OrderConfirmedEvent;
import tn.shopiny.commonapis.event.OrderCreatedEvent;
import tn.shopiny.orderservice.model.Order;
import tn.shopiny.orderservice.query.FindAllOrderedProductsQuery;
import tn.shopiny.orderservice.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
@Aggregate
public class OrderAggregate {

    private OrderRepository orderRepository;

    enum OrderStatus{
        CREATED,
        CONFIRMED
    }
    @AggregateIdentifier
    private String orderId;
    private boolean orderConfirmed;

    protected OrderAggregate(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    protected OrderAggregate() { }
    @CommandHandler
    public OrderAggregate(CreateOrderCommand command) {

        System.out.println("OrderAggregate OrderCreatedEvent invoked");

        apply(new OrderCreatedEvent(command.getOrderId(),command.getOrderDetails(),command.getDeliveryAddressId(), command.getName(),String.valueOf(OrderStatus.CREATED )));
    }

    @EventSourcingHandler
    public void on(OrderCreatedEvent event) {
        this.orderId = event.getOrderId();
        orderConfirmed = false;
      //  apply(new OrderConfirmedEvent(event.getOrderId(),event.getOrderDetails(),event.getDeliveryAddress(), event.getName(),String.valueOf(OrderStatus.CONFIRMED)));

    }
    @CommandHandler
    public void handle(ConfirmOrderCommand command) {
        if (orderConfirmed) {
            return;
        }
        apply(new OrderConfirmedEvent(command.getOrderId(),command.getOrderDetails(),command.getDeliveryAddressId(), command.getName(),String.valueOf(OrderStatus.CONFIRMED)));
    }

//    @CommandHandler
//    public void handle(ShipOrderCommand command) {
//        if (!orderConfirmed) {
//            throw new UnconfirmedOrderException();
//        }
//        AggregateLifecycle.apply(new OrderShippedEvent(orderId));
//    }

    @EventSourcingHandler
    public void on(OrderConfirmedEvent event) {
        orderConfirmed = true;
    }

    @QueryHandler
    public List<Order> handle(FindAllOrderedProductsQuery query) {
        List<Order> result = new ArrayList<Order>();
        orderRepository.findAll().forEach(result::add);
        return  result;
    }
}
