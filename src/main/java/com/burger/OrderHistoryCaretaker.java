package com.burger;

import java.util.Stack;

public class OrderHistoryCaretaker {
    private Stack<OrderMemento> history = new Stack<>();
    public void save(Order order) { history.push(order.createMemento()); }
    public void undo(Order order) { if (!history.isEmpty()) order.restore(history.pop()); }
}
