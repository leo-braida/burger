package com.burger;

public interface ComboAbstractFactory {
    Burger createBurger();
    Drink createDrink();
    Extra createExtra();
}
