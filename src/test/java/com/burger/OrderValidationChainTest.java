package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderValidationChainTest {

    @Test
    public void shouldPassDeliveryAreaValidation() {
        OrderValidationHandler area = new DeliveryAreaHandler();
        assertEquals(true, area.handle(new Order()));
    }

    @Test
    public void shouldPassStockValidation() {
        OrderValidationHandler stock = new StockHandler();
        assertEquals(true, stock.handle(new Order()));
    }

    @Test
    public void shouldPassPaymentValidation() {
        OrderValidationHandler payment = new PaymentHandler();
        assertEquals(true, payment.handle(new Order()));
    }

    @Test
    public void shouldProcessCompleteChain() {
        OrderValidationHandler area = new DeliveryAreaHandler();
        area.setNext(new StockHandler()).setNext(new PaymentHandler());
        assertEquals(true, area.handle(new Order()));
    }
}
