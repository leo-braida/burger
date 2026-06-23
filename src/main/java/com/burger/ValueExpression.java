package com.burger;

public class ValueExpression implements SearchExpression {
    private double minValue;
    public ValueExpression(double minValue) { this.minValue = minValue; }
    public boolean interpret(Order order) { return order.calculateTotal() > minValue; }
}
