package tn.shopiny.orderservice.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Embeddable
public class Money {


    public static Money ZERO = new Money(0);
    private BigDecimal amount;

    public Money() {
    }


    public Money(int i) {
        this.amount = new BigDecimal(i);
    }
    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money multiply(int n){
        return new Money(amount.multiply(new BigDecimal(n)));
    }

    public Money add(Money addedMoney) {
        return new Money(amount.add(addedMoney.amount));
    }
    public String asString() {
        return amount.toPlainString();
    }
}
