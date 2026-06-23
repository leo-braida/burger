package com.burger;

public class CentralDispatcher implements LogisticsMediator {
    private static final CentralDispatcher instance = new CentralDispatcher();
    private CourierApp courierApp = new CourierApp();
    private Object kitchenSystem = new Object();
    private CentralDispatcher() {}
    public static CentralDispatcher getInstance() { return instance; }
    public void notify(Object sender, String event) {
        if ("FOOD_READY".equals(event)) {
            System.out.println("Dispatching courier");
        }
    }
}
