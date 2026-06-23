package com.burger;

public class DrinkPackage implements ItemPackage {
    private static final DrinkPackage instance = new DrinkPackage();
    private String name = "drink package";

    private DrinkPackage() {}

    public static DrinkPackage getInstance() {
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
