package com.burger;

import java.util.HashMap;
import java.util.Map;

public class PackagingVisitor implements OrderVisitor {
    private Map<ItemPackage, Integer> packages = new HashMap<>();

    public void visitItem(OrderItem item) {
        ItemPackage pkg = item.getItemPackage();
        if (pkg != null) {
            packages.put(pkg, packages.getOrDefault(pkg, 0) + 1);
        }
    }
    public void visitCombo(Combo combo) {
        for (OrderComponent c : combo.getItems()) {
            c.accept(this);
        }
    }
    public void visitDecorator(OrderDecorator decorator) {
        decorator.getWrappedItem().accept(this);
    }
    
    public Map<ItemPackage, Integer> getPackages() {
        return packages;
    }
}
