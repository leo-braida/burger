package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderVisitorTest {

    @Test
    public void shouldVisitWithPricingVisitor() {
        OrderVisitor visitor = new PricingVisitor();
        boolean sucesso = true;
        try {
            new StandardBurger().accept(visitor);
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldVisitWithKitchenVisitor() {
        OrderVisitor visitor = new KitchenVisitor();
        boolean sucesso = true;
        try {
            new Combo().accept(visitor);
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldVisitWithPackagingVisitor() {
        OrderVisitor visitor = new PackagingVisitor();
        boolean sucesso = true;
        try {
            new Extra().accept(visitor);
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldVisitDecoratedElements() {
        OrderVisitor visitor = new PricingVisitor();
        OrderDecorator tip = new TipDecorator(new StandardBurger(), 1.0);
        boolean sucesso = true;
        try {
            tip.accept(visitor);
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldVisitComboWithPricingVisitor() {
        OrderVisitor visitor = new PricingVisitor();
        boolean sucesso = true;
        try {
            new Combo().accept(visitor);
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldVisitItemWithKitchenVisitor() {
        OrderVisitor visitor = new KitchenVisitor();
        boolean sucesso = true;
        try {
            new StandardBurger().accept(visitor);
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldVisitDecoratorWithKitchenVisitor() {
        OrderVisitor visitor = new KitchenVisitor();
        OrderDecorator tip = new TipDecorator(new StandardBurger(), 1.0);
        boolean sucesso = true;
        try {
            tip.accept(visitor);
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldVisitComboWithPackagingVisitor() {
        OrderVisitor visitor = new PackagingVisitor();
        boolean sucesso = true;
        try {
            new Combo().accept(visitor);
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldVisitDecoratorWithPackagingVisitor() {
        OrderVisitor visitor = new PackagingVisitor();
        OrderDecorator tip = new TipDecorator(new StandardBurger(), 1.0);
        boolean sucesso = true;
        try {
            tip.accept(visitor);
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldCollectCorrectPackagesForSingleItem() {
        PackagingVisitor visitor = new PackagingVisitor();
        Burger burger = new StandardBurger();
        burger.accept(visitor);
        
        java.util.Map<ItemPackage, Integer> pkgs = visitor.getPackages();
        assertEquals(1, pkgs.getOrDefault(BurgerPackage.getInstance(), 0));
        assertEquals("burger package", BurgerPackage.getInstance().getName());
    }

    @Test
    public void shouldCollectCorrectPackagesForMultipleItems() {
        PackagingVisitor visitor = new PackagingVisitor();
        Combo combo = new Combo();
        combo.addItem(new StandardBurger());
        combo.addItem(new StandardBurger());
        combo.addItem(new StandardBurger());
        combo.addItem(new Drink("Cola", 2.0));
        combo.addItem(new Extra("Fries", 3.0));
        
        combo.accept(visitor);
        
        java.util.Map<ItemPackage, Integer> pkgs = visitor.getPackages();
        assertEquals(3, pkgs.getOrDefault(BurgerPackage.getInstance(), 0));
        assertEquals(1, pkgs.getOrDefault(DrinkPackage.getInstance(), 0));
        assertEquals(1, pkgs.getOrDefault(FriesPackage.getInstance(), 0));
    }

    @Test
    public void shouldSetPackageName() {
        BurgerPackage.getInstance().setName("custom burger box");
        assertEquals("custom burger box", BurgerPackage.getInstance().getName());
        BurgerPackage.getInstance().setName("burger package");
    }

    @Test
    public void shouldGetInstructionsFromKitchenVisitor() {
        KitchenVisitor visitor = new KitchenVisitor();
        Burger burger = new StandardBurger();
        burger.accept(visitor);
        
        java.util.List<String> instructions = visitor.getInstructions();
        assertEquals(1, instructions.size());
        assertEquals("Prepare item: Standard Burger", instructions.get(0));
    }

    @Test
    public void shouldGetAndSetDrinkPackageName() {
        DrinkPackage.getInstance().setName("custom drink cup");
        assertEquals("custom drink cup", DrinkPackage.getInstance().getName());
        DrinkPackage.getInstance().setName("drink package");
    }

    @Test
    public void shouldGetAndSetFriesPackageName() {
        FriesPackage.getInstance().setName("custom fries bag");
        assertEquals("custom fries bag", FriesPackage.getInstance().getName());
        FriesPackage.getInstance().setName("fries package");
    }
}
