package com.burger;

public class AddItemCommand implements Command {
    private Order order;
    private OrderComponent item;
    public AddItemCommand(Order order, OrderComponent item) { this.order = order; this.item = item; }
    public void execute() { order.getItems().add(item); }
    public void undo() { order.getItems().remove(item); }
}
