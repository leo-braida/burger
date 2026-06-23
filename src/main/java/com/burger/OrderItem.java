package com.burger;

public class OrderItem extends OrderComponent {
    public OrderItem() {}
    public OrderItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public double getPrice() { return price; }
    @Override
    public OrderComponent clone() {
        return new OrderItem(this.name, this.price);
    }
    @Override
    public void accept(OrderVisitor visitor) {
        visitor.visitItem(this);
    }
}
