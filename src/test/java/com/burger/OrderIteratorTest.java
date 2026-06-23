package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderIteratorTest {

    @Test
    public void shouldReturnFalseForHasNextIfOrderEmpty() {
        Order order = new Order();
        OrderIterator iterator = order.createIterator();
        assertEquals(false, iterator.hasNext());
    }

    @Test
    public void shouldReturnTrueForHasNextWithItem() {
        Order order = new Order();
        order.getItems().add(new StandardBurger());
        OrderIterator iterator = order.createIterator();
        assertEquals(true, iterator.hasNext());
    }

    @Test
    public void shouldIterateOverMultipleItems() {
        Order order = new Order();
        order.getItems().add(new StandardBurger());
        order.getItems().add(new Drink());
        OrderIterator iterator = order.createIterator();
        iterator.next();
        assertEquals(true, iterator.next() instanceof Drink);
    }

    @Test
    public void shouldFailWhenIteratingBeyondLimit() {
        Order order = new Order();
        OrderIterator iterator = order.createIterator();
        boolean falhou = false;
        try {
            iterator.next();
        } catch (Exception e) {
            falhou = true;
        }
        assertEquals(true, falhou);
    }
}
