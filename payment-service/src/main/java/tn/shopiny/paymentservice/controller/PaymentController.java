package tn.shopiny.paymentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.shopiny.paymentservice.DTO.response.CreatePaymentResponse;
import tn.shopiny.paymentservice.service.PaymentService;

import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(path = "/create/{orderId}")
    public ResponseEntity<CreatePaymentResponse> createPayment(@PathVariable String orderId){
        String paymentId = paymentService.createPayment(orderId);
        return new ResponseEntity<>(new CreatePaymentResponse(orderId,paymentId), HttpStatus.CREATED);
    }
}
