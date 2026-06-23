package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchExpressionInterpreterTest {

    @Test
    public void shouldInterpretValueExpressionAsTrue() {
        Order order = new Order();
        order.getItems().add(new Cheeseburger());
        SearchExpression expr = new ValueExpression(5.0);
        assertEquals(true, expr.interpret(order));
    }

    @Test
    public void shouldInterpretValueExpressionAsFalse() {
        Order order = new Order();
        order.getItems().add(new Cheeseburger());
        SearchExpression expr = new ValueExpression(10.0);
        assertEquals(false, expr.interpret(order));
    }

    @Test
    public void shouldInterpretStatusExpressionAsTrue() {
        Order order = new Order();
        SearchExpression expr = new StatusExpression(NewState.class);
        assertEquals(true, expr.interpret(order));
    }

    @Test
    public void shouldInterpretCombinedAndExpression() {
        Order order = new Order();
        order.getItems().add(new StandardBurger());
        SearchExpression isNew = new StatusExpression(NewState.class);
        SearchExpression isBig = new ValueExpression(10.0);
        SearchExpression andExpr = new AndExpression(isNew, isBig);
        assertEquals(false, andExpr.interpret(order));
    }
}
