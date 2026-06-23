package com.burger;

public class BurgerFactory {
    public Burger createBurger(String type) {
        if ("Standard".equalsIgnoreCase(type)) return new StandardBurger();
        if ("Cheese".equalsIgnoreCase(type)) return new Cheeseburger();
        if ("Bacon".equalsIgnoreCase(type)) return new Baconburger();
        return null;
    }
}
