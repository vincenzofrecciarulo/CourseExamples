package org.generation.italy.examples.oo.patterns.factory.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryMethodTest {

    @Test
    void same_order_creates_different_products_in_different_pizzerias() {
        Pizzeria naplesPizzeria = new NaplesPizzeria();
        Pizzeria milanPizzeria = new MilanPizzeria();

        Pizza naplesPizza = naplesPizzeria.orderPizza(PizzaType.MARGHERITA);
        Pizza milanPizza = milanPizzeria.orderPizza(PizzaType.MARGHERITA);

        assertInstanceOf(NaplesMargheritaPizza.class, naplesPizza);
        assertInstanceOf(MilanMargheritaPizza.class, milanPizza);
        assertEquals("Margherita", naplesPizza.name());
        assertEquals("Margherita", milanPizza.name());
        assertNotEquals(naplesPizza.style(), milanPizza.style());
    }

    @Test
    void subclasses_decide_which_concrete_pizza_is_created() {
        Pizzeria pizzeria = new NaplesPizzeria();

        Pizza pizza = pizzeria.orderPizza(PizzaType.DIAVOLA);

        assertInstanceOf(NaplesDiavolaPizza.class, pizza);
        assertEquals("soft and dramatic Naples", pizza.style());
    }
}
