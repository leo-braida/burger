package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliverySystemFacadeTest {

    @Test
    public void shouldPlaceOrderChangingStateToReady() {
        DeliverySystemFacade facade = new DeliverySystemFacade();
        Order order = new Order();
        facade.placeOrder(order, new CashPayment());
        assertEquals(true, order.getState() instanceof ReadyState);
    }

    @Test
    public void shouldProcessPaymentInPlaceOrder() {
        DeliverySystemFacade facade = new DeliverySystemFacade();
        Order order = new Order();
        order.getItems().add(new Extra("Fritas", 5.0));
        boolean[] pago = {false};
        PaymentStrategy pagamento = amount -> {
            pago[0] = true;
            return true;
        };
        facade.placeOrder(order, pagamento);
        assertEquals(true, pago[0]);
    }

    @Test
    public void shouldReturnTrackingString() {
        DeliverySystemFacade facade = new DeliverySystemFacade();
        String track = facade.trackOrder("ID-99");
        assertEquals("Tracking ID-99", track);
    }

    @Test
    public void shouldProcessEmptyOrderWithoutFailing() {
        DeliverySystemFacade facade = new DeliverySystemFacade();
        Order order = new Order();
        boolean sucesso = true;
        try {
            facade.placeOrder(order, new CreditCardPayment());
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }
}
