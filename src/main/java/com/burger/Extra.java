package com.burger;

public class Extra extends OrderItem {
    public Extra() {
        this.itemPackage = FriesPackage.getInstance();
    }
    public Extra(String name, double price) {
        super(name, price);
        this.itemPackage = FriesPackage.getInstance();
    }
}
