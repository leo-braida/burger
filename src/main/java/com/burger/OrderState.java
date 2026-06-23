package com.burger;

public interface OrderState {
    void nextState(Order order);
    void cancelOrder(Order order);
}
