package com.burger;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id = "ORD-1";
    private OrderState state = NewState.getInstance();
    private PaymentStrategy paymentMethod;
    private OrderOriginPlatform originPlatform;
    private List<OrderComponent> items = new ArrayList<>();
    private List<OrderObserver> observers = new ArrayList<>();
    
    public void addObserver(OrderObserver o) { observers.add(o); }
    public void notifyObservers() { for (OrderObserver o : observers) o.update(this); }
    
    public void setState(OrderState state) { this.state = state; }
    public OrderState getState() { return state; }
    
    public void setPaymentMethod(PaymentStrategy p) { this.paymentMethod = p; }
    public PaymentStrategy getPaymentMethod() { return this.paymentMethod; }

    public void setOriginPlatform(OrderOriginPlatform p) { this.originPlatform = p; }
    public OrderOriginPlatform getOriginPlatform() { return this.originPlatform; }

    public void processPayment() {
        if (paymentMethod != null) paymentMethod.pay(calculateTotal());
    }
    
    public List<OrderComponent> getItems() { return items; }
    
    public OrderIterator createIterator() { return new OrderItemIterator(items); }
    
    public double calculateTotal() {
        PricingVisitor visitor = new PricingVisitor();
        for (OrderComponent item : items) {
            item.accept(visitor);
        }
        return visitor.getTotalPrice();
    }
    
    public OrderMemento createMemento() {
        List<OrderComponent> clonedItems = new ArrayList<>();
        for (OrderComponent c : items) clonedItems.add(c.clone());
        return new OrderMemento(state.getClass().getName(), clonedItems);
    }
    
    public void restore(OrderMemento m) {
        items = m.getItemsSnapshot();
        try {
            this.state = (OrderState) Class.forName(m.getStateData()).getMethod("getInstance").invoke(null);
        } catch (Exception e) {}
    }
}
