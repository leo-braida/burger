package com.burger;

public abstract class OrderDecorator extends OrderComponent {
    protected OrderComponent wrappedItem;
    public OrderDecorator(OrderComponent item) {
        this.wrappedItem = item;
        this.name = item.getName() + " (Decorated)";
    }
    public abstract double getPrice();
    
    public OrderComponent getWrappedItem() {
        return wrappedItem;
    }
    public void accept(OrderVisitor visitor) {
        visitor.visitDecorator(this);
    }
}
