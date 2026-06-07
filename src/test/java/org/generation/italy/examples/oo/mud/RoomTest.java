package org.generation.italy.examples.oo.mud;

import org.generation.italy.examples.oo.mud.world.*;
import org.generation.italy.examplesMio.ooMio.mudMio.equipmentMio.Item;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void add_and_remove_items_and_entities_and_players_list() {
        Room r = new Room("Test","desc", new ArrayList<>(), new ArrayList<>());

        Item sword = new Item(2.0, 10, "Sword");
        r.addItem(sword);
        assertTrue(r.getObjectNames().contains("Sword"));

        Item removed = r.removeItemByName("Sword");
        assertNotNull(removed);
        assertEquals("Sword", removed.getName());

        Player p = new Player(10, "Hero", 1);
        r.addEntity(p);
        assertTrue(r.getEntityNames().contains("Hero"));

        assertTrue(r.getPlayers().contains(p));

        boolean removedEntity = r.removeEntity(p);
        assertTrue(removedEntity);
    }

    @Test
    void prefix_matching_items_and_entities() {
        Room r = new Room("Test", "desc", new ArrayList<>(), new ArrayList<>());

        Item scudo = new Item(2.0, 15, "Scudo di ferro");
        Item spada = new Item(3.0, 20, "Spada di legno");
        r.addItem(scudo);
        r.addItem(spada);

        // Prefix match "scu" should find "Scudo di ferro"
        Item found = r.findItemByPrefix("scu");
        assertNotNull(found);
        assertEquals("Scudo di ferro", found.getName());

        // Prefix match "spa" should find "Spada di legno"
        Item found2 = r.findItemByPrefix("spa");
        assertNotNull(found2);
        assertEquals("Spada di legno", found2.getName());

        // Case insensitive
        Item found3 = r.findItemByPrefix("SCU");
        assertNotNull(found3);
        assertEquals("Scudo di ferro", found3.getName());

        // Non-existent prefix
        Item notFound = r.findItemByPrefix("xyz");
        assertNull(notFound);
    }

    @Test
    void prefix_matching_entities() {
        Room r = new Room("Test", "desc", new ArrayList<>(), new ArrayList<>());

        Entity lupo = new Monster(10, "Lupo Solitario", 2, 4);
        Entity oste = new Npc(5, "Oste Burlone", 1, "Benvenuto nella mia locanda.");
        r.addEntity(lupo);
        r.addEntity(oste);

        // Prefix match "lup" should find "Lupo Solitario"
        Entity found = r.findEntityByPrefix("lup");
        assertNotNull(found);
        assertEquals("Lupo Solitario", found.getName());

        // Prefix match "ost" should find "Oste Burlone"
        Entity found2 = r.findEntityByPrefix("ost");
        assertNotNull(found2);
        assertEquals("Oste Burlone", found2.getName());
    }

    @Test
    void items_and_entities_have_unique_ids() {
        Item item1 = new Item(1.0, 1, "Item1");
        Item item2 = new Item(1.0, 1, "Item2");
        assertTrue(item1.getId() != item2.getId(), "Items should have unique IDs");

        Entity e1 = new Monster(10, "E1", 1, 2);
        Entity e2 = new Npc(10, "E2", 1, "Ciao.");
        assertTrue(e1.getId() != e2.getId(), "Entities should have unique IDs");
    }
}
