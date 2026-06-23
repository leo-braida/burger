package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentStrategyTest {

    @Test
    public void shouldAcceptPositiveCredit() {
        PaymentStrategy cartao = new CreditCardPayment();
        assertEquals(true, cartao.pay(10.0));
    }

    @Test
    public void shouldRefuseNegativeCredit() {
        PaymentStrategy cartao = new CreditCardPayment();
        assertEquals(false, cartao.pay(-5.0));
    }

    @Test
    public void shouldAcceptPositiveCash() {
        PaymentStrategy dinheiro = new CashPayment();
        assertEquals(true, dinheiro.pay(15.0));
    }

    @Test
    public void shouldChargeCorrectOrderValue() {
        Order order = new Order();
        order.getItems().add(new Cheeseburger());
        double[] cobrado = {0.0};
        order.setPaymentMethod(amount -> {
            cobrado[0] = amount;
            return true;
        });
        order.processPayment();
        assertEquals(6.0, cobrado[0]);
    }

    @Test
    public void shouldPayWithPix() {
        PaymentStrategy pix = new PixPayment();
        assertEquals(true, pix.pay(10.0));
    }
}
