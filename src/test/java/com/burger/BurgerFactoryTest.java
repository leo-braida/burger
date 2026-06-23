package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BurgerFactoryTest {

    @Test
    public void shouldCreateStandardBurger() {
        BurgerFactory factory = new BurgerFactory();
        Burger burger = factory.createBurger("Standard");
        assertEquals(true, burger instanceof StandardBurger);
    }

    @Test
    public void shouldCreateCheeseburger() {
        BurgerFactory factory = new BurgerFactory();
        Burger burger = factory.createBurger("Cheese");
        assertEquals(true, burger instanceof Cheeseburger);
    }

    @Test
    public void shouldCreateBaconburger() {
        BurgerFactory factory = new BurgerFactory();
        Burger burger = factory.createBurger("Bacon");
        assertEquals(7.0, burger.getPrice());
    }

    @Test
    public void shouldReturnNullForInvalidType() {
        BurgerFactory factory = new BurgerFactory();
        Burger burger = factory.createBurger("Invalido");
        assertEquals(null, burger);
    }
}
