package com.burger;

import java.util.Map;
import java.util.HashMap;

public class IngredientFactory {
    private Map<String, IngredientFlyweight> ingredientsMap = new HashMap<>();
    public IngredientFlyweight getIngredient(String name) {
        if (!ingredientsMap.containsKey(name)) {
            int cal = name.equals("Meat") ? 200 : 50;
            ingredientsMap.put(name, new SharedIngredient(name, cal));
        }
        return ingredientsMap.get(name);
    }
}
