package org.generation.italy.examples.oo.patterns.factory.abstracfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryTest {

    @Test
    void sicilian_factory_creates_a_sicilian_family_of_foods() {
        ItalianFoodFactory factory = new SicilianFoodFactory();

        Menu menu = new Menu(factory);

        assertInstanceOf(SfincionePizza.class, menu.getPizza());
        assertInstanceOf(PastaAllaNorma.class, menu.getPasta());
        assertInstanceOf(RaguArancino.class, menu.getArancino());
        assertEquals("Sfincione + Pasta alla Norma + Arancino al ragu",
                menu.describe());
    }

    @Test
    void roman_factory_creates_a_roman_family_of_foods() {
        ItalianFoodFactory factory = new RomanFoodFactory();

        Menu menu = new Menu(factory);

        assertInstanceOf(PizzaBianca.class, menu.getPizza());
        assertInstanceOf(Carbonara.class, menu.getPasta());
        assertInstanceOf(SuppliDisguisedAsArancino.class, menu.getArancino());
        assertTrue(menu.describe().contains("Suppli"));
    }
}
