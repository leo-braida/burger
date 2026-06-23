package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemPreparerTemplateTest {

    @Test
    public void shouldExecuteFlowForBurger() {
        ItemPreparer preparer = new BurgerPreparer();
        boolean sucesso = true;
        try {
            preparer.process();
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldExecuteFlowForDrink() {
        ItemPreparer preparer = new DrinkPreparer();
        boolean sucesso = true;
        try {
            preparer.process();
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldEnsureInheritanceForBurger() {
        ItemPreparer preparer = new BurgerPreparer();
        assertEquals(true, preparer instanceof ItemPreparer);
    }

    @Test
    public void shouldEnsureInheritanceForDrink() {
        ItemPreparer preparer = new DrinkPreparer();
        assertEquals(true, preparer instanceof ItemPreparer);
    }
}
