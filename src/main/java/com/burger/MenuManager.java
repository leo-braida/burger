package com.burger;

import java.util.List;
import java.util.Arrays;

public class MenuManager {
    private static volatile MenuManager instance;
    private MenuManager() {}
    public static MenuManager getInstance() {
        if (instance == null) {
            synchronized(MenuManager.class) {
                if (instance == null) {
                    instance = new MenuManager();
                }
            }
        }
        return instance;
    }
    public List<OrderComponent> getMenu() {
        return Arrays.asList(new StandardBurger(), new Cheeseburger(), new Drink("Cola", 2.0));
    }
}
