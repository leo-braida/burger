package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderTest {

    @Test
    public void shouldSet() {
        Order order = new Order();
        PaymentStrategy payment = new PixPayment();
        order.setPaymentMethod(payment);
        assertEquals(true, order.getPaymentMethod() instanceof PixPayment);
    }

    @Test
    public void shouldSetOriginPlatform() {
        Order order = new Order();
        OrderOriginPlatform platform = new AppPlatform();
        order.setOriginPlatform(platform);
        assertEquals(true, order.getOriginPlatform() instanceof AppPlatform);
    }
}
