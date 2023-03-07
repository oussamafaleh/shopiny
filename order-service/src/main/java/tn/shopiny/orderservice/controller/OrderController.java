package tn.shopiny.orderservice.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.shopiny.orderservice.DTO.request.CreateOrderRequest;
import tn.shopiny.orderservice.DTO.response.CreateOrderResponse;
import tn.shopiny.orderservice.DTO.response.GetOrderResponse;
import tn.shopiny.orderservice.exception.OrderNotFoundException;
import tn.shopiny.orderservice.model.DeliveryInformation;
import tn.shopiny.orderservice.model.MenuItemIdAndQuantity;
import tn.shopiny.orderservice.model.Order;
import tn.shopiny.orderservice.repository.OrderRepository;
import tn.shopiny.orderservice.service.OrderService;

import java.util.Optional;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private OrderService orderService;

    private OrderRepository orderRepository;

    public OrderController(OrderService orderService,OrderRepository orderRepository) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    @GetMapping(path = "/{orderId}")
    public ResponseEntity<GetOrderResponse> getOrder(@PathVariable UUID orderId){
        Optional<Order> order = orderRepository.findById(orderId);
        return order
                .map(ord -> new ResponseEntity<>(new GetOrderResponse(ord), HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/{orderId}/cancel")
    public ResponseEntity<GetOrderResponse> cancelOrder(@PathVariable String orderId){
        try{
            Order order = orderService.cancel(orderId);
            return new ResponseEntity<>(new GetOrderResponse(order),HttpStatus.OK);
        }catch (OrderNotFoundException e ){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(path = "/create")
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest request){
        Order order = orderService.createOrder(
                request.getConsumerId(),
                request.getRestaurantId(),
                new DeliveryInformation(request.getDeleveryTime(),request.getDeliveryAddressAsAddress()),
                request.getLineItems().stream().map(lineItem -> new MenuItemIdAndQuantity(lineItem.getMenuItemId(),lineItem.getQuantity())).collect(Collectors.toList()));
    return new ResponseEntity<>(new CreateOrderResponse(order.getId()),HttpStatus.CREATED);
    }
}
