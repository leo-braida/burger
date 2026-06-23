package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryAPIAdapterTest {

    @Test
    public void shouldInstantiateIFoodAdapter() {
        DeliveryAPI api = new IFoodAdapter();
        assertEquals(true, api instanceof DeliveryAPI);
    }

    @Test
    public void shouldInstantiateRappiAdapter() {
        DeliveryAPI api = new RappiAdapter();
        assertEquals(true, api instanceof DeliveryAPI);
    }

    @Test
    public void shouldExecuteIFoodWithoutErrors() {
        DeliveryAPI api = new IFoodAdapter();
        boolean sucesso = true;
        try {
            api.sendOrderToPartner("Dados");
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }

    @Test
    public void shouldExecuteRappiWithoutErrors() {
        DeliveryAPI api = new RappiAdapter();
        boolean sucesso = true;
        try {
            api.sendOrderToPartner("Dados");
        } catch (Exception e) {
            sucesso = false;
        }
        assertEquals(true, sucesso);
    }
}
