package com.burger;

import java.util.List;

public class CachedMenuProxy implements MenuCacheProxy {
    private RealMenu realMenu = new RealMenu();
    private List<String> cache;
    public List<String> getAvailableItems() {
        if (cache == null) {
            cache = realMenu.getAvailableItems();
        }
        return cache;
    }
}
