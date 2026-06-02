package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.world.Item;
import org.generation.italy.examples.oo.mud.world.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void pick_up_drop_and_equip() {
        Player p = new Player(20, "Tester", 1);
        Item gem = new Item(0.1, 50, "Gem");
        assertTrue(p.pickUp(gem));
        assertTrue(p.getInventoryNames().contains("Gem"));

        assertTrue(p.equip("Gem"));
        assertNotNull(p.getEquipped());
        assertEquals("Gem", p.getEquipped().getName());

        var dropped = p.drop("Gem");
        assertTrue(dropped.isPresent());
        assertEquals("Gem", dropped.get().getName());
        assertFalse(p.getInventoryNames().contains("Gem"));
    }

    @Test
    void drop_and_equip_with_prefix_matching() {
        Player p = new Player(20, "Tester", 1);
        Item scudo = new Item(6.0, 20, "Scudo di ferro");
        Item spada = new Item(3.0, 25, "Spada di legno");

        p.pickUp(scudo);
        p.pickUp(spada);

        // Drop by prefix
        var dropped = p.dropByPrefix("scu");
        assertTrue(dropped.isPresent());
        assertEquals("Scudo di ferro", dropped.get().getName());
        assertFalse(p.getInventoryNames().contains("Scudo di ferro"));

        // Equip by prefix
        boolean equipped = p.equipByPrefix("spa");
        assertTrue(equipped);
        assertEquals("Spada di legno", p.getEquipped().getName());
    }

    @Test
    void prefix_matching_case_insensitive() {
        Player p = new Player(20, "Tester", 1);
        Item item = new Item(1.0, 10, "Scudo di ferro");
        p.pickUp(item);

        // Should match case-insensitively
        boolean equipped = p.equipByPrefix("SCUD");
        assertTrue(equipped);
        assertEquals("Scudo di ferro", p.getEquipped().getName());
    }
}

