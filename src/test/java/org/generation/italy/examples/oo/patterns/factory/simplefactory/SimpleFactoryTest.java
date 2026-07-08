package org.generation.italy.examples.oo.patterns.factory.simplefactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleFactoryTest {

    @Test
    void factory_creates_the_requested_pizza_type() {
        Pizza pizza = PizzaFactory.createPizza(PizzaType.DIAVOLA);

        assertInstanceOf(DiavolaPizza.class, pizza);
        assertEquals("Diavola", pizza.name());
        assertEquals("Tomato, mozzarella, spicy salami", pizza.description());
    }

    @Test
    void pizzeria_uses_the_factory_to_order_pizza() {
        Pizzeria pizzeria = new Pizzeria();

        Pizza pizza = pizzeria.orderPizza(PizzaType.PINEAPPLE_REVENGE);

        assertInstanceOf(PineappleRevengePizza.class, pizza);
        assertTrue(pizza.description().contains("apology"));
    }
}
