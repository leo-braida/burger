package com.burger;

public class PreparingState implements OrderState {
    private static final PreparingState instance = new PreparingState();
    private PreparingState() {}
    public static PreparingState getInstance() { return instance; }
    public void nextState(Order order) { order.setState(ReadyState.getInstance()); }
    public void cancelOrder(Order order) { order.setState(CancelledState.getInstance()); }
}
