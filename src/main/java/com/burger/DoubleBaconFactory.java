package com.burger;

public class DoubleBaconFactory implements ComboAbstractFactory {
    public Burger createBurger() { return new Baconburger(); }
    public Drink createDrink() { return new Drink("Soda", 2.0); }
    public Extra createExtra() { return new Extra("Fries", 3.0); }
}
