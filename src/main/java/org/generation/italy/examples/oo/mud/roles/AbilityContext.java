package org.generation.italy.examples.oo.mud.roles;

import org.generation.italy.examples.oo.mud.world.Entity;
import org.generation.italy.examples.oo.mud.world.Player;
import org.generation.italy.examples.oo.mud.world.PlayerSession;
import org.generation.italy.examples.oo.mud.world.Room;

import java.util.Optional;

public class AbilityContext {
    private final PlayerSession session;
    private final Player player;
    private final Room currentRoom;
    private final Entity combatTarget;

    AbilityContext(PlayerSession session, Player player, Room currentRoom, Entity combatTarget) {
        this.session = session;
        this.player = player;
        this.currentRoom = currentRoom;
        this.combatTarget = combatTarget;
    }

    public PlayerSession getSession() {
        return session;
    }

    public Player getPlayer() {
        return player;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Optional<Entity> getCombatTarget() {
        return Optional.ofNullable(combatTarget);
    }

    public boolean isInCombat() {
        return combatTarget != null;
    }

    public Entity resolveTarget(String targetName) {
        if(targetName == null || targetName.isBlank()){
            return combatTarget;
        }
        return currentRoom.findEntityByPrefix(targetName.trim());
    }
}
