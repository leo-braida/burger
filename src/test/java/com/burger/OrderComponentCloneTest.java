package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderComponentCloneTest {

    @Test
    public void shouldCloneOrderItem() {
        OrderItem original = new OrderItem("Teste", 10.0);
        OrderItem clone = (OrderItem) original.clone();
        assertEquals(false, original == clone);
    }

    @Test
    public void shouldCloneCombo() {
        Combo original = new Combo("Menu");
        original.addItem(new Drink("Cola", 2.0));
        Combo clone = (Combo) original.clone();
        assertEquals(2.0, clone.getPrice());
    }

    @Test
    public void shouldCloneDrinkAndExtra() {
        Drink originalDrink = new Drink("Agua", 1.0);
        OrderComponent cloneDrink = originalDrink.clone();
        assertEquals(1.0, cloneDrink.getPrice());
    }

    @Test
    public void shouldEnsureCloneIndependence() {
        Combo original = new Combo("Original");
        Combo clone = (Combo) original.clone();
        clone.addItem(new Extra("Gelo", 0.5));
        assertEquals(0.5, clone.getPrice());
    }
}
