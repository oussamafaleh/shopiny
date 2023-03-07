package tn.shopiny.paymentservice.service;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import tn.shopiny.commonapis.command.CreateInvoiceCommand;

import java.util.UUID;

@Service
public class PaymentService {

    private final CommandGateway commandGateway;

    public PaymentService(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public String createPayment(String orderId  ){
        String paymentId = UUID.randomUUID().toString();
        this.commandGateway.send(new CreateInvoiceCommand(paymentId,orderId));
        return paymentId;
    }
}
