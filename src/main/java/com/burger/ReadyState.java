package com.burger;

public class ReadyState implements OrderState {
    private static final ReadyState instance = new ReadyState();
    private ReadyState() {}
    public static ReadyState getInstance() { return instance; }
    public void nextState(Order order) { order.setState(DeliveringState.getInstance()); }
    public void cancelOrder(Order order) { order.setState(CancelledState.getInstance()); }
}
