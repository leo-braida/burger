package com.burger;

public class FriesPackage implements ItemPackage {
    private static final FriesPackage instance = new FriesPackage();
    private String name = "fries package";

    private FriesPackage() {}

    public static FriesPackage getInstance() {
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
