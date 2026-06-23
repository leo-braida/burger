package com.burger;

public class CancelledState implements OrderState {
    private static final CancelledState instance = new CancelledState();
    private CancelledState() {}
    public static CancelledState getInstance() { return instance; }
    public void nextState(Order order) { throw new IllegalStateException("Cannot process cancelled order."); }
    public void cancelOrder(Order order) { throw new IllegalStateException("Already cancelled."); }
}
