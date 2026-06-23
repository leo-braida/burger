package com.burger;

public class BurgerBuilder {
    private Burger burger;
    public BurgerBuilder() { reset(); }
    public void reset() { burger = new StandardBurger(); }
    public BurgerBuilder addMeat() { burger.addIngredient("Meat"); return this; }
    public BurgerBuilder addCheese() { burger.addIngredient("Cheese"); return this; }
    public BurgerBuilder addLettuce() { burger.addIngredient("Lettuce"); return this; }
    public Burger getResult() {
        Burger result = this.burger;
        reset();
        return result;
    }
}
