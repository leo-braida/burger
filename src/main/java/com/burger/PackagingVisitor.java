package com.burger;

public class PackagingVisitor implements OrderVisitor {
    public void visitItem(OrderItem item) {}
    public void visitCombo(Combo combo) {}
    public void visitDecorator(OrderDecorator decorator) {}
}
