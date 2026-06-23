package com.burger;

public abstract class OrderValidationHandler {
    protected OrderValidationHandler next;
    public OrderValidationHandler setNext(OrderValidationHandler h) { this.next = h; return h; }
    public boolean handle(Order order) {
        if (next != null) return next.handle(order);
        return true;
    }
}
