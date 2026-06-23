package com.burger;

public class Drink extends OrderItem {
    public Drink() {
        this.itemPackage = DrinkPackage.getInstance();
    }
    public Drink(String name, double price) {
        super(name, price);
        this.itemPackage = DrinkPackage.getInstance();
    }
}
