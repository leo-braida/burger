package com.burger;

import java.util.ArrayList;
import java.util.List;

public class KitchenVisitor implements OrderVisitor {
    private List<String> instructions = new ArrayList<>();

    public void visitItem(OrderItem item) {
        instructions.add("Prepare item: " + item.getName());
    }
    public void visitCombo(Combo combo) {
        instructions.add("Prepare combo: " + combo.getName());
        for (OrderComponent c : combo.getItems()) {
            c.accept(this);
        }
    }
    public void visitDecorator(OrderDecorator decorator) {
        instructions.add("Add decorator: " + decorator.getName());
        decorator.getWrappedItem().accept(this);
    }
    
    public List<String> getInstructions() {
        return instructions;
    }
}
