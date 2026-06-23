package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

public class MenuCacheProxyTest {

    @Test
    public void shouldLoadListFromRealMenu() {
        MenuCacheProxy proxy = new CachedMenuProxy();
        List<String> itens = proxy.getAvailableItems();
        assertEquals(2, itens.size());
    }

    @Test
    public void shouldKeepCacheOnSecondCall() {
        MenuCacheProxy proxy = new CachedMenuProxy();
        List<String> primeira = proxy.getAvailableItems();
        List<String> segunda = proxy.getAvailableItems();
        assertEquals(true, primeira == segunda);
    }

    @Test
    public void shouldContainBurgerInList() {
        MenuCacheProxy proxy = new CachedMenuProxy();
        List<String> itens = proxy.getAvailableItems();
        assertEquals(true, itens.contains("Burger"));
    }

    @Test
    public void shouldContainDrinkInList() {
        MenuCacheProxy proxy = new CachedMenuProxy();
        List<String> itens = proxy.getAvailableItems();
        assertEquals(true, itens.contains("Drink"));
    }
}
