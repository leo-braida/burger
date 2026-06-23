package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderStateTest {

    @Test
    public void shouldStartInNewState() {
        Order order = new Order();
        assertEquals(true, order.getState() instanceof NewState);
    }

    @Test
    public void shouldAdvanceToPreparingState() {
        Order order = new Order();
        order.getState().nextState(order);
        assertEquals(true, order.getState() instanceof PreparingState);
    }

    @Test
    public void shouldFailToAdvanceAfterDelivered() {
        Order order = new Order();
        order.setState(DeliveredState.getInstance());
        boolean falhou = false;
        try {
            order.getState().nextState(order);
        } catch (IllegalStateException e) {
            falhou = true;
        }
        assertEquals(true, falhou);
    }

    @Test
    public void shouldChangeToCancelled() {
        Order order = new Order();
        order.getState().cancelOrder(order);
        assertEquals(true, order.getState() instanceof CancelledState);
    }

    @Test
    public void shouldFailToCancelAfterDelivered() {
        Order order = new Order();
        order.setState(DeliveredState.getInstance());
        boolean failed = false;
        try {
            order.getState().cancelOrder(order);
        } catch (IllegalStateException e) {
            failed = true;
        }
        assertEquals(true, failed);
    }

    @Test
    public void shouldFailToAdvanceAfterCancelled() {
        Order order = new Order();
        order.setState(CancelledState.getInstance());
        boolean failed = false;
        try {
            order.getState().nextState(order);
        } catch (IllegalStateException e) {
            failed = true;
        }
        assertEquals(true, failed);
    }

    @Test
    public void shouldFailToCancelAfterCancelled() {
        Order order = new Order();
        order.setState(CancelledState.getInstance());
        boolean failed = false;
        try {
            order.getState().cancelOrder(order);
        } catch (IllegalStateException e) {
            failed = true;
        }
        assertEquals(true, failed);
    }

    @Test
    public void shouldAdvanceFromReadyToDelivering() {
        Order order = new Order();
        order.setState(ReadyState.getInstance());
        order.getState().nextState(order);
        assertEquals(true, order.getState() instanceof DeliveringState);
    }

    @Test
    public void shouldChangeToCancelledFromReady() {
        Order order = new Order();
        order.setState(ReadyState.getInstance());
        order.getState().cancelOrder(order);
        assertEquals(true, order.getState() instanceof CancelledState);
    }

    @Test
    public void shouldAdvanceFromPreparingToReady() {
        Order order = new Order();
        order.setState(PreparingState.getInstance());
        order.getState().nextState(order);
        assertEquals(true, order.getState() instanceof ReadyState);
    }

    @Test
    public void shouldChangeToCancelledFromPreparing() {
        Order order = new Order();
        order.setState(PreparingState.getInstance());
        order.getState().cancelOrder(order);
        assertEquals(true, order.getState() instanceof CancelledState);
    }

    @Test
    public void shouldChangeToCancelledFromDelivering() {
        Order order = new Order();
        order.setState(DeliveringState.getInstance());
        order.getState().cancelOrder(order);
        assertEquals(true, order.getState() instanceof CancelledState);
    }

    @Test
    public void shouldAdvanceFromDeliveringToDelivered() {
        Order order = new Order();
        order.setState(DeliveringState.getInstance());
        order.getState().nextState(order);
        assertEquals(true, order.getState() instanceof DeliveredState);
    }
}
