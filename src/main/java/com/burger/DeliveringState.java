package com.burger;

public class DeliveringState implements OrderState {
    private static final DeliveringState instance = new DeliveringState();
    private DeliveringState() {}
    public static DeliveringState getInstance() { return instance; }
    public void nextState(Order order) { order.setState(DeliveredState.getInstance()); }
    public void cancelOrder(Order order) { order.setState(CancelledState.getInstance()); }
}
