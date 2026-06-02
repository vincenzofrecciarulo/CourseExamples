package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.world.Player;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRolesTest {

    @Test
    void classes_generate_consistent_stats_and_have_abilities() {
        List<CharacterClass> classes = List.of(
                new Paladin(),
                new DarkPaladin(),
                new Thief(),
                new Mage(),
                new Priest(),
                new Barbarian(),
                new JuniorJavaProgrammer()
        );

        for(CharacterClass characterClass : classes){
            CharacterStats stats = characterClass.generateStats(new Random(42));
            assertTrue(stats.getIntelligence() >= 1 && stats.getIntelligence() <= 21);
            assertTrue(stats.getStrength() >= 1 && stats.getStrength() <= 21);
            assertTrue(stats.getStamina() >= 1 && stats.getStamina() <= 21);
            assertTrue(stats.getAgility() >= 1 && stats.getAgility() <= 21);
            assertTrue(stats.getWisdom() >= 1 && stats.getWisdom() <= 21);
            assertTrue(characterClass.calculateInitialHitPoints(stats) > 0);
        }
    }

    @Test
    void stat_categories_follow_the_expected_thresholds() {
        assertEquals(CharacterStats.StatCategory.VERY_POOR, CharacterStats.getCategory(5));
        assertEquals(CharacterStats.StatCategory.AVERAGE, CharacterStats.getCategory(6));
        assertEquals(CharacterStats.StatCategory.AVERAGE, CharacterStats.getCategory(12));
        assertEquals(CharacterStats.StatCategory.GOOD, CharacterStats.getCategory(13));
        assertEquals(CharacterStats.StatCategory.GOOD, CharacterStats.getCategory(17));
        assertEquals(CharacterStats.StatCategory.EXCELLENT, CharacterStats.getCategory(18));
    }

    @Test
    void factory_creates_a_player_with_class_and_stats() {
        CharacterFactory factory = new CharacterFactory(new Random(7));
        Player player = factory.create("Test", 1, new JuniorJavaProgrammer());

        assertEquals("Test", player.getName());
        assertEquals("Programmatore Java Junior", player.getCharacterClass().getName());
        assertNotNull(player.getStats());
        assertTrue(player.getMaxHitPoints() > 0);
        assertFalse(player.getSpecialAbilities().isEmpty());
    }
}
