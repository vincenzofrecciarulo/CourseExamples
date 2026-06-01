package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.Player;

import java.util.List;
import java.util.Random;

public class CharacterFactory {
    private final Random random;

    public CharacterFactory(Random random) {
        this.random = random;
    }

    public Player create(String name, int level, CharacterClass characterClass) {
        CharacterStats stats = characterClass.generateStats(random);
        int hitPoints = characterClass.calculateInitialHitPoints(stats);
        return new Player(hitPoints, name, level, characterClass, stats);
    }

    public List<CharacterClass> availableClasses() {
        return List.of(
                new Paladin(),
                new DarkPaladin(),
                new Thief(),
                new Mage(),
                new Priest(),
                new Barbarian(),
                new JuniorJavaProgrammer()
        );
    }
}
