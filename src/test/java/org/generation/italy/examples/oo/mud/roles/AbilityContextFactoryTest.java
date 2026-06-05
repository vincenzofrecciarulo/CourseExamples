package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.world.Entity;
import org.generation.italy.examples.oo.mud.world.GameContext;
import org.generation.italy.examples.oo.mud.world.Monster;
import org.generation.italy.examples.oo.mud.world.Player;
import org.generation.italy.examples.oo.mud.world.PlayerSession;
import org.generation.italy.examples.oo.mud.world.Room;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AbilityContextFactoryTest {

    @Test
    void base_context_has_no_combat_target() {
        Player player = new Player(20, "Tester", 1);
        Room room = new Room("Room", "Description", new ArrayList<>(), new ArrayList<>());
        GameContext gameContext = new GameContext(dummyIo(), room, player);

        AbilityContext abilityContext = AbilityContextFactory.from(gameContext);

        assertSame(player, abilityContext.getPlayer());
        assertSame(room, abilityContext.getCurrentRoom());
        assertTrue(abilityContext.getCombatTarget().isEmpty());
        assertFalse(abilityContext.isInCombat());
    }

    @Test
    void combat_context_exposes_the_current_opponent() {
        Player player = new Player(20, "Tester", 1);
        Room room = new Room("Room", "Description", new ArrayList<>(), new ArrayList<>());
        Entity opponent = new Monster(10, "Goblin", 1, 2);
        room.addEntity(opponent);
        GameContext gameContext = new GameContext(dummyIo(), room, player);

        AbilityContext abilityContext = AbilityContextFactory.inCombat(gameContext, opponent);

        assertSame(opponent, abilityContext.getCombatTarget().orElseThrow());
        assertSame(opponent, abilityContext.resolveTarget(""));
        assertTrue(abilityContext.isInCombat());
    }

    private PlayerSession dummyIo() {
        return new PlayerSession() {
            @Override
            public void send(String message) {
            }

            @Override
            public String readCommand(String prompt) {
                return "";
            }
        };
    }
}
