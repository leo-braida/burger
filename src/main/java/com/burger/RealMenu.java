package com.burger;

import java.util.List;
import java.util.Arrays;

public class RealMenu implements MenuCacheProxy {
    public List<String> getAvailableItems() {
        return Arrays.asList("Burger", "Drink");
    }
}
