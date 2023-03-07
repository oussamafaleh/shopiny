package tn.shopiny.orderservice.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
@Access(AccessType.FIELD)
public class PaymentInformation {

  private String paymentToken;
}
