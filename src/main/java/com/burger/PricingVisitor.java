package com.burger;

public class PricingVisitor implements OrderVisitor {
    public void visitItem(OrderItem item) {}
    public void visitCombo(Combo combo) {}
    public void visitDecorator(OrderDecorator decorator) {}
}
