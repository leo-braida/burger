package com.burger;

public class StatusExpression implements SearchExpression {
    private Class requiredState;
    public StatusExpression(Class requiredState) { this.requiredState = requiredState; }
    public boolean interpret(Order order) { return requiredState.isInstance(order.getState()); }
}
