package com.burger;

public class CreditCardPayment implements PaymentStrategy {
    public boolean pay(double amount) { return amount > 0; }
}
