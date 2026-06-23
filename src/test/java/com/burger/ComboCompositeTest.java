package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComboCompositeTest {

    @Test
    public void shouldReturnZeroPriceForEmptyCombo() {
        Combo combo = new Combo("Vazio");
        assertEquals(0.0, combo.getPrice());
    }

    @Test
    public void shouldSumPriceOfIndividualItems() {
        Combo combo = new Combo("Normal");
        combo.addItem(new StandardBurger());
        combo.addItem(new Drink("Cola", 2.0));
        assertEquals(7.0, combo.getPrice());
    }

    @Test
    public void shouldSumPriceOfNestedCombos() {
        Combo comboMaior = new Combo("Maior");
        Combo comboMenor = new Combo("Menor");
        comboMenor.addItem(new Cheeseburger());
        comboMaior.addItem(comboMenor);
        comboMaior.addItem(new Extra("Fritas", 3.0));
        assertEquals(9.0, comboMaior.getPrice());
    }

    @Test
    public void shouldKeepComboName() {
        Combo combo = new Combo("Meu Combo Especial");
        assertEquals("Meu Combo Especial", combo.getName());
    }
}
