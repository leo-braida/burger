package com.burger;

public class CashPayment implements PaymentStrategy {
    public boolean pay(double amount) { return amount > 0; }
}
