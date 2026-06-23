package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderOriginPlatformTest {

    @Test
    public void shouldProcessAppOrigin() {
        OrderOriginPlatform plataforma = new AppPlatform();
        assertEquals("App Customer Data", plataforma.processOriginDetails());
    }

    @Test
    public void shouldProcessWhatsappOrigin() {
        OrderOriginPlatform plataforma = new WhatsappPlatform();
        assertEquals("WhatsApp Customer Data", plataforma.processOriginDetails());
    }

    @Test
    public void shouldEnsureAppPlatformImplementsInterface() {
        OrderOriginPlatform plataforma = new AppPlatform();
        assertEquals(true, plataforma instanceof OrderOriginPlatform);
    }

    @Test
    public void shouldEnsureWhatsappPlatformImplementsInterface() {
        OrderOriginPlatform plataforma = new WhatsappPlatform();
        assertEquals(true, plataforma instanceof OrderOriginPlatform);
    }
}
