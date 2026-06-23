package com.burger;

import java.util.ArrayList;
import java.util.List;

public class Combo extends OrderComponent {
    private List<OrderComponent> items = new ArrayList<>();
    
    public Combo() {}
    public Combo(String name) { this.name = name; }
    
    public List<OrderComponent> getItems() {
        return items;
    }
    
    public void addItem(OrderComponent item) {
        items.add(item);
    }
    
    @Override
    public double getPrice() {
        return items.stream().mapToDouble(OrderComponent::getPrice).sum();
    }
    
    @Override
    public OrderComponent clone() {
        Combo cloned = new Combo(this.name);
        for (OrderComponent item : items) {
            cloned.addItem(item.clone());
        }
        return cloned;
    }
    
    @Override
    public void accept(OrderVisitor visitor) {
        visitor.visitCombo(this);
    }
}
