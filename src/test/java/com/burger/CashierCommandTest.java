package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashierCommandTest {

    @Test
    public void shouldExecuteItemAddition() {
        Order order = new Order();
        Command add = new AddItemCommand(order, new Extra());
        add.execute();
        assertEquals(1, order.getItems().size());
    }

    @Test
    public void shouldUndoItemAddition() {
        Order order = new Order();
        Command add = new AddItemCommand(order, new Extra());
        add.execute();
        add.undo();
        assertEquals(0, order.getItems().size());
    }

    @Test
    public void shouldExecuteOrderCancellation() {
        Order order = new Order();
        Command cancel = new CancelOrderCommand(order);
        cancel.execute();
        assertEquals(true, order.getState() instanceof CancelledState);
    }

    @Test
    public void shouldProcessCommandsInInvoker() {
        Order order = new Order();
        CashierInvoker invoker = new CashierInvoker();
        invoker.executeCommand(new AddItemCommand(order, new Extra()));
        assertEquals(1, order.getItems().size());
    }

    @Test
    public void shouldUndoOrderCancellation() {
        Order order = new Order();
        Command cancel = new CancelOrderCommand(order);
        cancel.execute();
        cancel.undo();
        assertEquals(true, order.getState() instanceof NewState);
    }

    @Test
    public void shouldUndoCommandInInvoker() {
        Order order = new Order();
        CashierInvoker invoker = new CashierInvoker();
        invoker.executeCommand(new AddItemCommand(order, new Extra()));
        invoker.undoCommand();
        assertEquals(0, order.getItems().size());
    }
}
