package com.burger;

public class PricingVisitor implements OrderVisitor {
    private double totalPrice = 0.0;

    public void visitItem(OrderItem item) {
        totalPrice += item.getPrice();
    }
    public void visitCombo(Combo combo) {
        totalPrice += combo.getPrice();
    }
    public void visitDecorator(OrderDecorator decorator) {
        totalPrice += decorator.getPrice();
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
}
