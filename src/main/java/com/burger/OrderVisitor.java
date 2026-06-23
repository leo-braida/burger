package com.burger;

public interface OrderVisitor {
    void visitItem(OrderItem item);
    void visitCombo(Combo combo);
    void visitDecorator(OrderDecorator decorator);
}
