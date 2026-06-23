package com.burger;

public class RappiAdapter implements DeliveryAPI {
    private Object rappiService = new Object();
    public void sendOrderToPartner(String orderDetails) {
        System.out.println("Sending to Rappi: " + orderDetails);
    }
}
