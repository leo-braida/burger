package com.burger;

import java.util.ArrayList;
import java.util.List;

public abstract class Burger extends OrderItem {
    protected List<String> ingredients = new ArrayList<>();
    public Burger() {}
    public Burger(String name, double price) {
        super(name, price);
    }
    public void addIngredient(String ing) {
        ingredients.add(ing);
    }
    public List<String> getIngredients() {
        return ingredients;
    }
}
