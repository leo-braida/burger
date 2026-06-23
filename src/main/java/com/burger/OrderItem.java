package com.burger;

public class OrderItem extends OrderComponent {
    protected ItemPackage itemPackage;

    public OrderItem() {}
    public OrderItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public ItemPackage getItemPackage() {
        return itemPackage;
    }

    @Override
    public double getPrice() { return price; }
    @Override
    public OrderComponent clone() {
        OrderItem clone = new OrderItem(this.name, this.price);
        clone.itemPackage = this.itemPackage;
        return clone;
    }
    @Override
    public void accept(OrderVisitor visitor) {
        visitor.visitItem(this);
    }
}
