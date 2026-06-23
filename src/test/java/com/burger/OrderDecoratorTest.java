package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderDecoratorTest {

    @Test
    public void shouldAddDeliveryFee() {
        OrderItem item = new OrderItem("Teste", 10.0);
        OrderDecorator comEntrega = new DeliveryFeeDecorator(item, 5.0);
        assertEquals(15.0, comEntrega.getPrice());
    }

    @Test
    public void shouldAddTip() {
        OrderItem item = new OrderItem("Teste", 10.0);
        OrderDecorator comGorjeta = new TipDecorator(item, 2.5);
        assertEquals(12.5, comGorjeta.getPrice());
    }

    @Test
    public void shouldAccumulateDecorators() {
        OrderItem item = new OrderItem("Teste", 10.0);
        OrderDecorator tip = new TipDecorator(item, 2.0);
        OrderDecorator fee = new DeliveryFeeDecorator(tip, 3.0);
        assertEquals(15.0, fee.getPrice());
    }

    @Test
    public void shouldModifyDecoratedItemName() {
        OrderItem item = new OrderItem("Pizza", 20.0);
        OrderDecorator tip = new TipDecorator(item, 2.0);
        assertEquals("Pizza (Decorated)", tip.getName());
    }

    @Test
    public void shouldCloneTipDecorator() {
        OrderItem item = new OrderItem("Pizza", 20.0);
        OrderDecorator tip = new TipDecorator(item, 2.0);
        OrderDecorator clone = (OrderDecorator) tip.clone();
        assertEquals(22.0, clone.getPrice());
    }

    @Test
    public void shouldCloneDeliveryFeeDecorator() {
        OrderItem item = new OrderItem("Pizza", 20.0);
        OrderDecorator fee = new DeliveryFeeDecorator(item, 5.0);
        OrderDecorator clone = (OrderDecorator) fee.clone();
        assertEquals(25.0, clone.getPrice());
    }
}
