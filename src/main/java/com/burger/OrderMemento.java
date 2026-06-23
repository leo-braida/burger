package com.burger;

import java.util.List;

public class OrderMemento {
    private String stateData;
    private List<OrderComponent> itemsSnapshot;
    public OrderMemento(String stateData, List<OrderComponent> itemsSnapshot) {
        this.stateData = stateData;
        this.itemsSnapshot = itemsSnapshot;
    }
    public String getStateData() { return stateData; }
    public List<OrderComponent> getItemsSnapshot() { return itemsSnapshot; }
}
