package com.burger;

public class DeliveryFeeDecorator extends OrderDecorator {
    private double deliveryFee;
    public DeliveryFeeDecorator(OrderComponent item, double fee) {
        super(item);
        this.deliveryFee = fee;
    }
    public double getPrice() { return wrappedItem.getPrice() + deliveryFee; }

    public DeliveryFeeDecorator clone() {
        return new DeliveryFeeDecorator(this.wrappedItem.clone(), this.deliveryFee);
    }
}
