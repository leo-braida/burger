package com.burger;

public abstract class OrderComponent implements Cloneable {
    protected String name;
    protected double price;
    
    public String getName() { return name; }
    public abstract double getPrice();
    public abstract OrderComponent clone();
    public abstract void accept(OrderVisitor visitor);
}
