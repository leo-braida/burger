package com.burger;

public class TipDecorator extends OrderDecorator {
    private double tipAmount;
    public TipDecorator(OrderComponent item, double tip) {
        super(item);
        this.tipAmount = tip;
    }
    public double getPrice() { return wrappedItem.getPrice() + tipAmount; }

    public TipDecorator clone() {
        return new TipDecorator(this.wrappedItem.clone(), this.tipAmount);
    }
}
