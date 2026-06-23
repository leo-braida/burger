package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BurgerBuilderTest {

    @Test
    public void shouldCreateBurgerWithoutExtraIngredients() {
        BurgerBuilder builder = new BurgerBuilder();
        Burger burger = builder.getResult();
        assertEquals(0, burger.getIngredients().size());
    }

    @Test
    public void shouldAddMeatToBurger() {
        BurgerBuilder builder = new BurgerBuilder();
        Burger burger = builder.addMeat().getResult();
        assertEquals(true, burger.getIngredients().contains("Meat"));
    }

    @Test
    public void shouldAddMultipleIngredients() {
        BurgerBuilder builder = new BurgerBuilder();
        Burger burger = builder.addCheese().addLettuce().getResult();
        assertEquals(2, burger.getIngredients().size());
    }

    @Test
    public void shouldResetStateAfterGetResult() {
        BurgerBuilder builder = new BurgerBuilder();
        builder.addMeat();
        Burger burger1 = builder.getResult();
        Burger burger2 = builder.getResult();
        assertEquals(0, burger2.getIngredients().size());
    }
}
