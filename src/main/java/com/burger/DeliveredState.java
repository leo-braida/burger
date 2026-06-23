package com.burger;

public class DeliveredState implements OrderState {
    private static final DeliveredState instance = new DeliveredState();
    private DeliveredState() {}
    public static DeliveredState getInstance() { return instance; }
    public void nextState(Order order) { throw new IllegalStateException("Already delivered."); }
    public void cancelOrder(Order order) { throw new IllegalStateException("Cannot cancel delivered order."); }
}
