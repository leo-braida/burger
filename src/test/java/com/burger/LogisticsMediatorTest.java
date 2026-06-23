package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogisticsMediatorTest {

    @Test
    public void shouldEnsureUniqueInstanceOfMediator() {
        CentralDispatcher d1 = CentralDispatcher.getInstance();
        CentralDispatcher d2 = CentralDispatcher.getInstance();
        assertEquals(true, d1 == d2);
    }

    @Test
    public void shouldImplementMediatorInterface() {
        CentralDispatcher dispatcher = CentralDispatcher.getInstance();
        assertEquals(true, dispatcher instanceof LogisticsMediator);
    }

    @Test
    public void shouldNotifyFoodReadyEventWithoutFailing() {
        CentralDispatcher dispatcher = CentralDispatcher.getInstance();
        boolean sucesso = true;
        try {
            dispatcher.notify(this, "FOOD_READY");
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldSilentlyIgnoreUnknownEvents() {
        CentralDispatcher dispatcher = CentralDispatcher.getInstance();
        boolean sucesso = true;
        try {
            dispatcher.notify(this, "OUTRO_EVENTO");
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }
}
