package com.burger;

public class CancelOrderCommand implements Command {
    private Order order;
    public CancelOrderCommand(Order order) { this.order = order; }
    public void execute() { order.getState().cancelOrder(order); }
    public void undo() { order.setState(NewState.getInstance()); }
}
