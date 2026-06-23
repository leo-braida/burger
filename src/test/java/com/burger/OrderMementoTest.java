package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderMementoTest {

    @Test
    public void shouldSaveCurrentOrderState() {
        Order order = new Order();
        order.getItems().add(new Extra());
        OrderMemento memento = order.createMemento();
        assertEquals(1, memento.getItemsSnapshot().size());
    }

    @Test
    public void shouldRestorePreviousState() {
        Order order = new Order();
        order.getItems().add(new Extra());
        OrderMemento memento = order.createMemento();
        order.getItems().clear();
        order.restore(memento);
        assertEquals(1, order.getItems().size());
    }

    @Test
    public void shouldSaveStateOnlyInCaretaker() {
        OrderHistoryCaretaker caretaker = new OrderHistoryCaretaker();
        Order order = new Order();
        boolean sucesso = true;
        try {
            caretaker.save(order);
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldUndoFromCaretaker() {
        OrderHistoryCaretaker caretaker = new OrderHistoryCaretaker();
        Order order = new Order();
        order.getItems().add(new Drink());
        caretaker.save(order);
        order.getItems().clear();
        caretaker.undo(order);
        assertEquals(1, order.getItems().size());
    }
}
