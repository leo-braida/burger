package com.burger;

public class AndExpression implements SearchExpression {
    private SearchExpression expr1;
    private SearchExpression expr2;
    public AndExpression(SearchExpression expr1, SearchExpression expr2) {
        this.expr1 = expr1; this.expr2 = expr2;
    }
    public boolean interpret(Order order) { return expr1.interpret(order) && expr2.interpret(order); }
}
