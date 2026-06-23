package com.burger;

public class CourierApp implements OrderObserver {
    public void update(Order order) {
        System.out.println("Courier notified");
    }
}
