package com.burger;

public class NewState implements OrderState {
    private static final NewState instance = new NewState();
    private NewState() {}
    public static NewState getInstance() { return instance; }
    public void nextState(Order order) { order.setState(PreparingState.getInstance()); }
    public void cancelOrder(Order order) { order.setState(CancelledState.getInstance()); }
}
