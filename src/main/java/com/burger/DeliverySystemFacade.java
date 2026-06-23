package com.burger;

public class DeliverySystemFacade {
    private CentralDispatcher dispatcher = CentralDispatcher.getInstance();
    private MenuManager menuManager = MenuManager.getInstance();
    public void placeOrder(Order order, PaymentStrategy payment) {
        order.setPaymentMethod(payment);
        order.processPayment();
        order.setState(ReadyState.getInstance());
        dispatcher.notify(this, "FOOD_READY");
    }
    public String trackOrder(String orderId) { return "Tracking " + orderId; }
}
