package com.burger;

import java.util.List;

public class OrderItemIterator implements OrderIterator {
    private List<OrderComponent> items;
    private int position = 0;
    public OrderItemIterator(List<OrderComponent> items) { this.items = items; }
    public boolean hasNext() { return position < items.size(); }
    public OrderComponent next() { return items.get(position++); }
}
