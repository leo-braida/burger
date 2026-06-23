package com.burger;

public class BurgerPackage implements ItemPackage {
    private static final BurgerPackage instance = new BurgerPackage();
    private String name = "burger package";

    private BurgerPackage() {}

    public static BurgerPackage getInstance() {
        return instance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
