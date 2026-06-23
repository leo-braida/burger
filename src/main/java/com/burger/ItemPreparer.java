package com.burger;

public abstract class ItemPreparer {
    public void process() {
        prepareIngredients();
        cook();
        packageItem();
    }
    protected abstract void prepareIngredients();
    protected abstract void cook();
    protected void packageItem() { System.out.println("Packaging"); }
}
