package com.burger;

public class CheeseLoveFactory implements ComboAbstractFactory {
    public Burger createBurger() { return new Cheeseburger(); }
    public Drink createDrink() { return new Drink("Juice", 2.5); }
    public Extra createExtra() { return new Extra("Onion Rings", 3.5); }
}
