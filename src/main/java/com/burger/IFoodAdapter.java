package com.burger;

public class IFoodAdapter implements DeliveryAPI {
    private Object ifoodService = new Object();
    public void sendOrderToPartner(String orderDetails) {
        System.out.println("Sending to iFood: " + orderDetails);
    }
}
