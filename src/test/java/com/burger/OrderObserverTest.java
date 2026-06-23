package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderObserverTest {

    @Test
    public void shouldNotifyOneObserver() {
        Order order = new Order();
        int[] contagem = {0};
        order.addObserver(o -> contagem[0]++);
        order.notifyObservers();
        assertEquals(1, contagem[0]);
    }

    @Test
    public void shouldNotifyMultipleObservers() {
        Order order = new Order();
        int[] contagem = {0};
        order.addObserver(o -> contagem[0]++);
        order.addObserver(o -> contagem[0]++);
        order.addObserver(o -> contagem[0]++);
        order.notifyObservers();
        assertEquals(3, contagem[0]);
    }

    @Test
    public void shouldExecuteClientAppWithoutErrors() {
        Order order = new Order();
        order.addObserver(new ClientApp());
        boolean sucesso = true;
        try {
            order.notifyObservers();
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldExecuteCourierAppWithoutErrors() {
        Order order = new Order();
        order.addObserver(new CourierApp());
        boolean sucesso = true;
        try {
            order.notifyObservers();
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }
}
