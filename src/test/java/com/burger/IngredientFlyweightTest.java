package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IngredientFlyweightTest {

    @Test
    public void shouldReturnSameInstanceForSameName() {
        IngredientFactory factory = new IngredientFactory();
        IngredientFlyweight ing1 = factory.getIngredient("Meat");
        IngredientFlyweight ing2 = factory.getIngredient("Meat");
        assertEquals(true, ing1 == ing2);
    }

    @Test
    public void shouldReturnDifferentInstancesForDifferentNames() {
        IngredientFactory factory = new IngredientFactory();
        IngredientFlyweight ing1 = factory.getIngredient("Meat");
        IngredientFlyweight ing2 = factory.getIngredient("Cheese");
        assertEquals(false, ing1 == ing2);
    }

    @Test
    public void shouldAssignCorrectCaloriesForMeat() {
        IngredientFactory factory = new IngredientFactory();
        IngredientFlyweight carne = factory.getIngredient("Meat");
        assertEquals(200, carne.getCalories());
    }

    @Test
    public void shouldAssignDefaultCaloriesForOthers() {
        IngredientFactory factory = new IngredientFactory();
        IngredientFlyweight alface = factory.getIngredient("Lettuce");
        assertEquals(50, alface.getCalories());
    }

    @Test
    public void shouldGetSharedIngredientName() {
        IngredientFactory factory = new IngredientFactory();
        IngredientFlyweight ing = factory.getIngredient("Meat");
        assertEquals("Meat", ing.getName());
    }
}
