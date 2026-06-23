package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComboAbstractFactoryTest {

    @Test
    public void shouldCreateDoubleBaconCombo() {
        ComboAbstractFactory factory = new DoubleBaconFactory();
        assertEquals(true, factory.createBurger() instanceof Baconburger);
    }

    @Test
    public void shouldCreateCheeseLoveCombo() {
        ComboAbstractFactory factory = new CheeseLoveFactory();
        assertEquals("Juice", factory.createDrink().getName());
    }

    @Test
    public void shouldValidateDoubleBaconComboPrices() {
        ComboAbstractFactory factory = new DoubleBaconFactory();
        assertEquals(3.0, factory.createExtra().getPrice());
    }

    @Test
    public void shouldValidateCheeseLoveComboPrices() {
        ComboAbstractFactory factory = new CheeseLoveFactory();
        assertEquals(6.0, factory.createBurger().getPrice());
    }

    @Test
    public void shouldCreateDrinkForDoubleBacon() {
        ComboAbstractFactory factory = new DoubleBaconFactory();
        assertEquals("Soda", factory.createDrink().getName());
    }

    @Test
    public void shouldCreateExtraForCheeseLove() {
        ComboAbstractFactory factory = new CheeseLoveFactory();
        assertEquals("Onion Rings", factory.createExtra().getName());
    }
}
