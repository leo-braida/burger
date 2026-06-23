package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class MenuManagerTest {

    @Test
    public void shouldEnsureUniqueInstance() {
        MenuManager instancia1 = MenuManager.getInstance();
        MenuManager instancia2 = MenuManager.getInstance();
        assertEquals(true, instancia1 == instancia2);
    }

    @Test
    public void shouldReturnMenuWithThreeItems() {
        List<OrderComponent> menu = MenuManager.getInstance().getMenu();
        assertEquals(3, menu.size());
    }

    @Test
    public void shouldReturnNonNullInstance() {
        MenuManager instancia = MenuManager.getInstance();
        assertEquals(true, instancia != null);
    }

    @Test
    public void shouldContainStandardBurgerInMenu() {
        List<OrderComponent> menu = MenuManager.getInstance().getMenu();
        assertEquals(true, menu.get(0) instanceof StandardBurger);
    }
}
