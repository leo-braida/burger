package com.burger;

public class ClientApp implements OrderObserver {
    public void update(Order order) {
        System.out.println("Client notified");
    }
}
