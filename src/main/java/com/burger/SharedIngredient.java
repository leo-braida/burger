package com.burger;

public class SharedIngredient implements IngredientFlyweight {
    private String name;
    private int calories;
    public SharedIngredient(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }
    public String getName() { return name; }
    public int getCalories() { return calories; }
}
