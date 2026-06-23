package com.burger;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BurgerPatternsTest {

    @Test
    public void testSingleton() {
        MenuManager m1 = MenuManager.getInstance();
        MenuManager m2 = MenuManager.getInstance();
        assertSame(m1, m2);
        assertNotNull(m1.getMenu());
    }

    @Test
    public void testBuilder() {
        BurgerBuilder builder = new BurgerBuilder();
        Burger b = builder.addMeat().addCheese().getResult();
        assertTrue(b.getIngredients().contains("Meat"));
        assertTrue(b.getIngredients().contains("Cheese"));
    }

    @Test
    public void testFactoryMethod() {
        BurgerFactory factory = new BurgerFactory();
        Burger b1 = factory.createBurger("Standard");
        assertTrue(b1 instanceof StandardBurger);
        Burger b2 = factory.createBurger("Bacon");
        assertTrue(b2 instanceof Baconburger);
    }

    @Test
    public void testAbstractFactory() {
        ComboAbstractFactory fac = new DoubleBaconFactory();
        assertTrue(fac.createBurger() instanceof Baconburger);
        assertTrue(fac.createDrink() instanceof Drink);
    }

    @Test
    public void testPrototypeAndComposite() {
        Combo c1 = new Combo("C1");
        c1.addItem(new Drink("D1", 2.0));
        Combo c2 = (Combo) c1.clone();
        assertEquals(2.0, c2.getPrice());
        assertNotSame(c1, c2);
    }
    
    @Test
    public void testBridge() {
        OrderOriginPlatform p = new WhatsappPlatform();
        assertEquals("WhatsApp Customer Data", p.processOriginDetails());
    }
    
    @Test
    public void testDecorator() {
        OrderItem item = new OrderItem("I1", 10.0);
        OrderDecorator dec = new DeliveryFeeDecorator(item, 5.0);
        assertEquals(15.0, dec.getPrice());
    }
    
    @Test
    public void testFlyweight() {
        IngredientFactory f = new IngredientFactory();
        IngredientFlyweight i1 = f.getIngredient("Meat");
        IngredientFlyweight i2 = f.getIngredient("Meat");
        assertSame(i1, i2);
    }
    
    @Test
    public void testFacade() {
        DeliverySystemFacade f = new DeliverySystemFacade();
        Order o = new Order();
        PaymentStrategy mockPay = mock(PaymentStrategy.class);
        f.placeOrder(o, mockPay);
        verify(mockPay).pay(anyDouble());
        assertTrue(o.getState() instanceof ReadyState);
    }
    
    @Test
    public void testProxy() {
        MenuCacheProxy proxy = new CachedMenuProxy();
        assertNotNull(proxy.getAvailableItems());
    }
    
    @Test
    public void testAdapter() {
        DeliveryAPI api = new IFoodAdapter();
        api.sendOrderToPartner("Order");
        // Ensure no crash
    }
    
    @Test
    public void testState() {
        Order o = new Order();
        assertTrue(o.getState() instanceof NewState);
        o.getState().nextState(o);
        assertTrue(o.getState() instanceof PreparingState);
        o.getState().cancelOrder(o);
        assertTrue(o.getState() instanceof CancelledState);
        assertThrows(IllegalStateException.class, () -> o.getState().nextState(o));
    }
    
    @Test
    public void testStrategy() {
        PaymentStrategy p = new CreditCardPayment();
        assertTrue(p.pay(10.0));
    }
    
    @Test
    public void testObserver() {
        Order o = new Order();
        OrderObserver obs = mock(OrderObserver.class);
        o.addObserver(obs);
        o.notifyObservers();
        verify(obs).update(o);
    }
    
    @Test
    public void testIterator() {
        Order o = new Order();
        o.getItems().add(new Drink("D", 1.0));
        OrderIterator it = o.createIterator();
        assertTrue(it.hasNext());
        assertNotNull(it.next());
    }
    
    @Test
    public void testMediator() {
        CentralDispatcher d = CentralDispatcher.getInstance();
        d.notify(this, "FOOD_READY");
    }
    
    @Test
    public void testCommand() {
        Order o = new Order();
        OrderItem i = new OrderItem("I", 1.0);
        Command c = new AddItemCommand(o, i);
        CashierInvoker invoker = new CashierInvoker();
        invoker.executeCommand(c);
        assertEquals(1, o.getItems().size());
        invoker.undoCommand();
        assertEquals(0, o.getItems().size());
    }
    
    @Test
    public void testChain() {
        OrderValidationHandler h1 = new DeliveryAreaHandler();
        h1.setNext(new PaymentHandler());
        assertTrue(h1.handle(new Order()));
    }
    
    @Test
    public void testTemplateMethod() {
        ItemPreparer p = new BurgerPreparer();
        p.process();
    }
    
    @Test
    public void testMemento() {
        Order o = new Order();
        o.getItems().add(new Drink("D", 1.0));
        OrderHistoryCaretaker c = new OrderHistoryCaretaker();
        c.save(o);
        o.getItems().clear();
        c.undo(o);
        assertEquals(1, o.getItems().size());
    }
    
    @Test
    public void testInterpreter() {
        Order o = new Order();
        o.getItems().add(new Drink("D", 10.0));
        SearchExpression expr = new ValueExpression(5.0);
        assertTrue(expr.interpret(o));
    }
    
    @Test
    public void testVisitor() {
        OrderItem i = new OrderItem("I", 1.0);
        OrderVisitor v = new PricingVisitor();
        i.accept(v);
    }
}
